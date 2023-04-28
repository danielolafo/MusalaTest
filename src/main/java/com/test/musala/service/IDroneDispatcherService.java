package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;

public interface IDroneDispatcherService {


	ResponseEntity<ResponseDto<DroneDto>> registerDrone(DroneDto droneDto);

	ResponseEntity<ResponseDto<DroneDto>> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine);

	ResponseEntity<ResponseDto<Boolean>> checkLoad(BigDecimal droneId);

	ResponseEntity<ResponseDto<Double>> checkBatteryLevel(BigDecimal droneId);

	ResponseEntity<ResponseDto<List<DroneDto>>> checkAvailableDrones();

}
