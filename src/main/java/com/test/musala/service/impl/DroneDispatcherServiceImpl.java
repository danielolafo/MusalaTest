package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.mapper.DroneMapper;
import com.test.musala.repository.DroneRepository;
import com.test.musala.service.IDroneDispatcherService;

@Service
public class DroneDispatcherServiceImpl implements IDroneDispatcherService {
	
	private DroneRepository droneRepository;
	
	public DroneDispatcherServiceImpl(DroneRepository droneRepository) {
		this.droneRepository=droneRepository;
	}

	@Override
	public ResponseEntity<DroneDto> registerDrone(DroneDto droneDto) {
		droneRepository.save(DroneMapper.INSTANCE.dtoToEntity(droneDto));
		return  new ResponseEntity<DroneDto>(HttpStatus.OK);
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
