package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.MedicineRequestDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.entity.Drone;

/**
 * 
 * Version 1
 * @author Daniel Orlando López Ochoa
 */
public interface IDroneChargeService {
	
	public ResponseEntity<Double> getTotalChargeByFlight(BigDecimal droneFlightId);

	ResponseEntity<ResponseDto<Boolean>> updateCharge(BigDecimal droneId, MedicineRequestDto medicineRequestDto);

	void validate(Drone drone) throws Exception;
	
	void validate(Drone drone, List<MedicineDto> lstMedicineDtos) throws Exception;

}
