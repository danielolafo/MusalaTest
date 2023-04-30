package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneFlightDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.entity.Drone;
import com.test.musala.entity.DroneCharge;
import com.test.musala.enums.DroneState;
import com.test.musala.repository.DroneChargeRepository;
import com.test.musala.repository.DroneRepository;
import com.test.musala.service.IDroneChargeService;
import com.test.musala.service.IDroneFlightService;
import com.test.musala.service.IMedicineService;

@Service
public class DroneChargeServiceImpl implements IDroneChargeService{
	
	private IDroneFlightService droneFlightService;
	
	public final DroneChargeRepository droneChargeRepository;
	
	private final IMedicineService medicineService;
	
	public static final Double BATTERY_LIMIT = Double.valueOf(25.0);
	private static final BigDecimal LOAD_EXCEED = BigDecimal.valueOf(1);
	private static final BigDecimal INSUFICIENT_BATTERY = BigDecimal.valueOf(2);
	private static final BigDecimal NORMAL_CODE = BigDecimal.valueOf(0);
	
	public DroneChargeServiceImpl(
			DroneChargeRepository droneChargeRepository,
			IDroneFlightService droneFlightService,
			IMedicineService medicineService) {
		this.droneChargeRepository=droneChargeRepository;
		this.droneFlightService=droneFlightService;
		this.medicineService = medicineService;
	}

	@Override
	public ResponseEntity<Double> getTotalChargeByFlight(BigDecimal droneFlightId) {
		Double totalCharge = droneChargeRepository.findByDroneFlightId(droneFlightId)
		.stream()
		.mapToDouble(droneCharge -> droneCharge.getDispatchedAmount()*droneCharge.getDispatchedAmount())
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
			resp = Boolean.TRUE;
		}else {
			droneFlightDto = new DroneFlightDto();
			droneFlightDto.setDroneId(droneId);
			droneFlightDto.setOrigin(null);
			droneFlightDto.setTarget(null);
			droneFlightDto.setDispatchedDate(new Date());
			this.droneFlightService.create(droneFlightDto);
			this.saveAllChargeInfo(droneId, lstMedicines);
			resp= Boolean.TRUE;
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
	
	/**
	 * Validate if the battery level of the drone is insuficient or the
	 * total load weight exceeds the drone weight limit.
	 * If battery of weight validation failed, throws an exception with 
	 * the correspondign message.
	 * If battery level is enough of total load weight is under the limit,
	 * method does nothing.
	 */
	@Override
	public void validate(Drone drone, List<MedicineDto> lstMedicineDto) throws Exception {
		BigDecimal result = this.validateBattery(drone).add(this.validateLoadWeight(drone,lstMedicineDto));
		switch(result.intValue()) {
		case 1:
			throw new Exception("The load weight exceeds maximum drone weight limit. Drone weight limit : "+drone.getWeightLimit());
		case 2:
			throw new Exception("The battery level for this delivery is insuficient. The batter level must be greater than 25%. Current battery level : "+drone.getBatteryPercentage());
		case 3:
			throw new Exception("The drone medicines could not be loaded");
		default:
			break;
		}
	}
	
	private BigDecimal validateBattery(Drone drone) {
		return drone.getBatteryPercentage().compareTo(DroneChargeServiceImpl.BATTERY_LIMIT)<0 ? DroneChargeServiceImpl.INSUFICIENT_BATTERY: DroneChargeServiceImpl.NORMAL_CODE;
	}
	
	
	/**
	 * Validate the current added items total weight plus new items total weight.
	 * If maximum drone weight limit is exceeded, then return LOAD_EXCEED code.
	 * Else return 0.
	 * @param drone
	 * @return
	 */
	private BigDecimal validateLoadWeight(Drone drone, List<MedicineDto> lstMedicineDto) {
		BigDecimal newItemsTotalWeight = getNewItemsWeight(lstMedicineDto);
		BigDecimal currentAndNewTotalWeight = getCurrentLoadWeight(drone).add(newItemsTotalWeight);
		return currentAndNewTotalWeight.compareTo(BigDecimal.valueOf(drone.getWeightLimit()))>0 ? DroneChargeServiceImpl.LOAD_EXCEED: BigDecimal.ZERO;
	}
	
	/**
	 * Returns the total weight of the current loaded medicine items in the drone
	 * @param drone
	 * @return
	 */
	public BigDecimal getCurrentLoadWeight(Drone drone) {
		BigDecimal currentTotalWeight = BigDecimal.valueOf(0);
		ResponseEntity<DroneFlightDto> responseFlight = 
				this.droneFlightService.getCurrentDroneFlight(drone.getId());
		if(responseFlight.hasBody()) {
			List<DroneCharge> lstCharges = this.droneChargeRepository
			.findByDroneFlightId(responseFlight.getBody().getId());
			for(DroneCharge charge : lstCharges) {
				currentTotalWeight = currentTotalWeight.add(BigDecimal.valueOf(charge.getDispatchedAmount()*this.medicineService.getMedicineById(charge.getMedicineId()).getWeight()));
			}
		}
		return currentTotalWeight;
	}
	
	/**
	 * Returns the total weight of the new medicine to be loaded on the drone
	 * @param lstMedicinesDto
	 * @return
	 */
	public BigDecimal getNewItemsWeight(List<MedicineDto> lstMedicinesDto) {
		Double newTotalWeight = lstMedicinesDto.stream().mapToDouble(item -> 
			item.getWeight()*item.getQuantity().doubleValue()).sum();
		return BigDecimal.valueOf(newTotalWeight);
	}

	@Override
	public void validate(Drone drone) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
