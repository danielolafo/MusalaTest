package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;

public interface IDroneDispatcherService {


	ResponseEntity<DroneDto> registerDrone(DroneDto droneDto);

	ResponseEntity<DroneDto> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine);

	ResponseEntity<Boolean> checkLoad(BigDecimal droneId);


	ResponseEntity<Double> checkBatteryLevel(BigDecimal droneId);

	ResponseEntity<List<DroneDto>> checkAvailableDrones();

}
