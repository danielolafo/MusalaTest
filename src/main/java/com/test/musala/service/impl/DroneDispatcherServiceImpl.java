package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.entity.Drone;
import com.test.musala.mapper.DroneMapper;
import com.test.musala.repository.DroneRepository;
import com.test.musala.service.IDroneDispatcherService;

@Service
public class DroneDispatcherServiceImpl implements IDroneDispatcherService {
	
	private DroneRepository droneRepository;
	
	public DroneDispatcherServiceImpl(DroneRepository droneRepository) {
		this.droneRepository=droneRepository;
	}

	@Override
	public ResponseEntity<DroneDto> registerDrone(DroneDto droneDto) {
		droneRepository.save(DroneMapper.INSTANCE.dtoToEntity(droneDto));
		return  new ResponseEntity<DroneDto>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DroneDto> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine) {
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			Drone drone = droneOpt.get();
			
			return new ResponseEntity<>(null);
		}
		return null;
	}

	@Override
	public ResponseEntity<Boolean> checkLoad(BigDecimal droneId) {
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			Drone drone = droneOpt.get();
			return new ResponseEntity<>(null);
		}
		return null;
	}

	@Override
	public ResponseEntity<List<DroneDto>> checkAvailableDrones() {
		List<DroneDto> lstDronesDto = new ArrayList<>();
		this.droneRepository.getAvailableDrones()
				.stream().forEach(drone -> {
					lstDronesDto.add(DroneMapper.INSTANCE.entityToDto(drone));
				});
		return new ResponseEntity<>(lstDronesDto, 
				!lstDronesDto.isEmpty() ? HttpStatus.OK: HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Double> checkBatteryLevel(BigDecimal droneId) {
		Optional<Drone> droneOpt = droneRepository.findById(droneId);
		if(droneOpt.isPresent()) {
			return new ResponseEntity<>(droneOpt.get().getBatteryPercentage(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
