package com.test.musala.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneFlightDto;

public interface IDroneFlightService {
	
	public ResponseEntity<DroneFlightDto> getCurrentDroneFlight(BigDecimal droneId);

}
