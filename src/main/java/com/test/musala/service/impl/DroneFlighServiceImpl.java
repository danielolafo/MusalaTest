package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneFlightDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.entity.DroneFlight;
import com.test.musala.mapper.DroneFlightMapper;
import com.test.musala.repository.DroneFlightRepository;
import com.test.musala.service.IDroneFlightService;

@Service
public class DroneFlighServiceImpl implements IDroneFlightService {
	
	private final DroneFlightRepository droneFlightRepository;
	
	public DroneFlighServiceImpl(DroneFlightRepository droneFlightRepository) {
		this.droneFlightRepository = droneFlightRepository;
	}

	public ResponseEntity<DroneFlightDto> getCurrentDroneFlight(BigDecimal droneId){
		Optional<DroneFlight> droneFlightOpt = droneFlightRepository.getCurrentDroneFlight(droneId);
		if(droneFlightOpt.isPresent()) {
			return new ResponseEntity<>(
					DroneFlightMapper.INSTANCE.entityToDto(droneFlightOpt.get()), 
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new DroneFlightDto(), HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<ResponseDto<DroneFlightDto>> create(DroneFlightDto droneFlightDto){
		DroneFlight droneFlight = this.droneFlightRepository.save(DroneFlightMapper.INSTANCE.dtoToEntity(droneFlightDto));
		droneFlightDto.setId(droneFlight.getId());
		return new ResponseEntity<>(new ResponseDto<>(droneFlightDto), HttpStatus.OK);
	}

}
