package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneFlightDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.entity.Drone;
import com.test.musala.entity.DroneCharge;
import com.test.musala.repository.DroneChargeRepository;
import com.test.musala.service.IDroneChargeService;
import com.test.musala.service.IDroneFlightService;

import net.bytebuddy.asm.Advice.This;

@Service
public class DroneChargeServiceImpl implements IDroneChargeService{
	
	private IDroneFlightService droneFlightService;
	
	public final DroneChargeRepository droneChargeRepository;
	
	public static final Double BATTERY_LIMIT = Double.valueOf(25.0);
	private static final BigDecimal LOAD_EXCEED = BigDecimal.valueOf(1);
	private static final BigDecimal INSUFICIENT_BATTERY = BigDecimal.valueOf(2);
	private static final BigDecimal NORMAL_CODE = BigDecimal.valueOf(0);
	
	public DroneChargeServiceImpl(
			DroneChargeRepository droneChargeRepository,
			IDroneFlightService droneFlightService) {
		this.droneChargeRepository=droneChargeRepository;
		this.droneFlightService=droneFlightService;
	}

	@Override
	public ResponseEntity<Double> getTotalChargeByFlight(BigDecimal droneFlightId) {
		Double totalCharge = droneChargeRepository.findByDroneFlightId(droneFlightId)
		.stream()
		.mapToDouble(droneCharge -> droneCharge.getDispatchedAmount())
		.reduce(0, Double::sum);
		return new ResponseEntity<>(totalCharge, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseDto<Boolean>> updateCharge(BigDecimal droneId, List<MedicineDto> lstMedicines){
		Boolean resp = Boolean.FALSE;
		DroneFlightDto droneFlightDto = new DroneFlightDto(); 
		ResponseEntity<DroneFlightDto> responseFlight = this.droneFlightService.getCurrentDroneFlight(droneId);
		if(responseFlight.hasBody() && Objects.nonNull(responseFlight.getBody())) {
			droneFlightDto = responseFlight.getBody();
			resp = this.saveAllChargeInfo(droneFlightDto.getId(), lstMedicines);
		}else {
			droneFlightDto = new DroneFlightDto();
			droneFlightDto.setDroneId(droneId);
			droneFlightDto.setOrigin(null);
			droneFlightDto.setTarget(null);
			droneFlightDto.setDispatchedDate(new Date());
			this.droneFlightService.create(droneFlightDto);
		}
		return new ResponseEntity<>(new ResponseDto<>(resp),HttpStatus.OK);
	}
	
	private Boolean saveAllChargeInfo(BigDecimal droneFlightId, List<MedicineDto> lstMedicines) {
		try {
			for(MedicineDto med : lstMedicines) {
				DroneCharge droneCharge = new DroneCharge();
				droneCharge.setDroneFlightId(droneFlightId);
				droneCharge.setMedicineId(med.getId());
				droneCharge.setDispatchedAmount(med.getWeight()*med.getQuantity().doubleValue());
				droneChargeRepository.save(droneCharge);
			}
			return Boolean.TRUE;
		}catch(Exception e) {
			return Boolean.FALSE;
		}
	}
	
	private void validate(Drone drone) throws Exception {
		BigDecimal result = this.validateBattery(drone).add(this.validateLoadWeight(drone));
		switch(result.intValue()) {
		case 1:
			throw new Exception("The load weight exceeds maximum drone weight limit");
		case 2:
			throw new Exception("The battery level for this delivery is insuficient. The batter level must be greater than 25%");
		default:
			break;
		}
	}
	
	private BigDecimal validateBattery(Drone drone) {
		return drone.getBatteryPercentage().compareTo(DroneChargeServiceImpl.BATTERY_LIMIT)<0 ? DroneChargeServiceImpl.INSUFICIENT_BATTERY: DroneChargeServiceImpl.NORMAL_CODE;
	}
	
	private BigDecimal validateLoadWeight(Drone drone) {
		return DroneChargeServiceImpl.LOAD_EXCEED;
	}
	

}
