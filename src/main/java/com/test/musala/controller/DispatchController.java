package com.test.musala.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineDto;
import com.test.musala.service.IDroneDispatcherService;

@RestController
@RequestMapping("dispatcher")
public class DispatchController {
	
	private IDroneDispatcherService dispatcherService;
	
	public DispatchController(IDroneDispatcherService dispatcherService) {
		this.dispatcherService = dispatcherService;
	}
	
	@PostMapping("register-drone")
	public ResponseEntity<DroneDto> registerDrone(@RequestBody DroneDto droneDto) {
		return dispatcherService.registerDrone(droneDto);
	}
	
	@PutMapping("load-medicine/{droneId}")
	public ResponseEntity<DroneDto> loadMedicione(BigDecimal droneId, List<MedicineDto> medicine) {
		return null;
	}
	
	@GetMapping("check-load/{droneId}")
	public ResponseEntity<Boolean> checkLoad(BigDecimal droneId) {
		return null;
	}
	
	@GetMapping("get-available-drones")
	public ResponseEntity<List<DroneDto>> checkAvailableDrones() {
		return null;
	}
	
	@GetMapping("get-battery-level/{droneId}")
	public ResponseEntity<Double> checkBatteryLevel(BigDecimal droneId) {
		return null;
	}

}
