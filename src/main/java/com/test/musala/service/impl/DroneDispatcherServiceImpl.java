package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.entity.Drone;
import com.test.musala.mapper.DroneMapper;
import com.test.musala.repository.DroneRepository;
import com.test.musala.service.IDroneChargeService;
import com.test.musala.service.IDroneDispatcherService;
import com.test.musala.service.IDroneFlightService;
import com.test.musala.service.IMedicineService;

@Service
public class DroneDispatcherServiceImpl implements IDroneDispatcherService {
	
	private IDroneChargeService droneChargeService;
	private IDroneFlightService droneFlightService;
	private IMedicineService medicineService;
	
	private DroneRepository droneRepository;
	
	public DroneDispatcherServiceImpl(DroneRepository droneRepository, 
			IDroneChargeService droneChargeService,
			IDroneFlightService droneFlightService,
			IMedicineService medicineService) {
		this.droneRepository=droneRepository;
		this.droneChargeService=droneChargeService;
		this.medicineService=medicineService;
		this.droneFlightService=droneFlightService;
	}

	@Override
	public ResponseEntity<ResponseDto<DroneDto>> registerDrone(DroneDto droneDto) {
		Drone drone = droneRepository.save(DroneMapper.INSTANCE.dtoToEntity(droneDto));
		droneDto.setId(drone.getId());
		return  new ResponseEntity<>(new ResponseDto<DroneDto>(droneDto),HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<ResponseDto<DroneDto>> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine) {
		Drone drone = new Drone();
		Double newTotalWeight = medicine.stream().mapToDouble(med ->
			med.getWeight()).sum();
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			drone = droneOpt.get();
			if(newTotalWeight > drone.getWeightLimit() || (newTotalWeight + this.getCurrentDroneChargeWeight(droneId)>drone.getWeightLimit())) {
				return new ResponseEntity<>(
						new ResponseDto<>(new DroneDto(),"The weight exceeds drone max capacity"),
						HttpStatus.CONFLICT);
			}
			
		}
		String message = Objects.nonNull(drone.getId()) ? null : "Drone information not found"; 
		Boolean saved = this.updateFlightCharge(droneId, medicine);
		return new ResponseEntity<>(new ResponseDto<>(DroneMapper.INSTANCE.entityToDto(drone),message), saved ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	private Boolean updateFlightCharge(BigDecimal droneId, List<MedicineDto> medicine) {
		return droneChargeService.updateCharge(droneId, medicine).getBody().getData();
	}
	

	@Override
	public ResponseEntity<ResponseDto<Boolean>> checkLoad(BigDecimal droneId) {
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			BigDecimal currentFlightId = droneFlightService.getCurrentDroneFlight(droneId).getBody().getId();
			Double totalWeight = droneChargeService.getTotalChargeByFlight(currentFlightId).getBody();
			return new ResponseEntity<>(new ResponseDto<>(totalWeight<=droneOpt.get().getWeightLimit()), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto<>(Boolean.FALSE, "The drone load cannot be greater than Its maximum capacity"), 
				HttpStatus.CONFLICT);
	}

	@Override
	public ResponseEntity<ResponseDto<List<DroneDto>>> checkAvailableDrones() {
		List<DroneDto> lstDronesDto = new ArrayList<>();
		this.droneRepository.getAvailableDrones()
				.stream().forEach(drone -> {
					lstDronesDto.add(DroneMapper.INSTANCE.entityToDto(drone));
				});
		return new ResponseEntity<>(new ResponseDto<>(lstDronesDto), 
				!lstDronesDto.isEmpty() ? HttpStatus.OK: HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseDto<Double>> checkBatteryLevel(BigDecimal droneId) {
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			return new ResponseEntity<>(new ResponseDto<>(droneOpt.get().getBatteryPercentage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto<>(0.0, "The drone doesn't exists"),HttpStatus.NOT_FOUND);
	}
	
	private Double getCurrentDroneChargeWeight(BigDecimal droneId) {
		ResponseEntity<ResponseDto<List<MedicineDto>>> response = 
				this.medicineService.checkLoadedMedicine(droneId);
		if(Objects.nonNull(
				response.getBody()) 
				&& Objects.nonNull(response.getBody().getData()) 
				&& !response.getBody().getData().isEmpty()) {
			return response.getBody().getData().stream().mapToDouble(medicine ->
					medicine.getWeight()).sum();
		}else {
			return 0.0;
		}
	}

}
