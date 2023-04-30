package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineRequestDto;
import com.test.musala.dto.ResponseDto;

public interface IDroneDispatcherService {


	public ResponseEntity<ResponseDto<DroneDto>> registerDrone(DroneDto droneDto);

	public ResponseEntity<ResponseDto<DroneDto>> loadMedicione(BigDecimal droneId, MedicineRequestDto medicineRequestDto);

	public ResponseEntity<ResponseDto<Boolean>> checkLoad(BigDecimal droneId);

	public ResponseEntity<ResponseDto<Double>> checkBatteryLevel(BigDecimal droneId);

	public ResponseEntity<ResponseDto<List<DroneDto>>> checkAvailableDrones();
	
	public ResponseEntity<ResponseDto<List<DroneDto>>> getAllDrones();

}
