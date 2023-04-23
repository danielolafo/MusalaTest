package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.service.IDroneDispatcherService;

public class DroneDispatcherServiceImpl implements IDroneDispatcherService {

	@Override
	public ResponseEntity<DroneDto> registerDrone(DroneDto droneDto) {
		return null;
	}

	@Override
	public ResponseEntity<DroneDto> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine) {
		return null;
	}

	@Override
	public ResponseEntity<Boolean> checkLoad(BigDecimal droneId) {
		return null;
	}

	@Override
	public ResponseEntity<List<DroneDto>> checkAvailableDrones() {
		return null;
	}

	@Override
	public ResponseEntity<Double> checkBatteryLevel(BigDecimal droneId) {
		return null;
	}

}
