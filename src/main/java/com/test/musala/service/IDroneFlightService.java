package com.test.musala.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.DroneFlightDto;
import com.test.musala.dto.ResponseDto;

public interface IDroneFlightService {
	
	public ResponseEntity<DroneFlightDto> getCurrentDroneFlight(BigDecimal droneId);

	ResponseEntity<ResponseDto<DroneFlightDto>> create(DroneFlightDto droneFlightDto);

}
