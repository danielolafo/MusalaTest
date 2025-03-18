package com.test.musala.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.MedicineRequestDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.service.IDroneDispatcherService;

/**
 * 
 * 
 * @author Daniel Orlando López Ochoa
 */
@RestController
@RequestMapping("dispatcher")
@CrossOrigin("*")
public class DispatchController {
	
	private IDroneDispatcherService dispatcherService;
	
	public DispatchController(IDroneDispatcherService dispatcherService) {
		this.dispatcherService = dispatcherService;
	}
	
	@PostMapping("/register-drone")
	public ResponseEntity<ResponseDto<DroneDto>> registerDrone(@Valid @RequestBody DroneDto droneDto) {
		return dispatcherService.registerDrone(droneDto);
	}
	
	@PutMapping("/load-medicine/{droneId}")
	public ResponseEntity<ResponseDto<DroneDto>> loadMedicione(@PathVariable("droneId") BigDecimal droneId, @RequestBody MedicineRequestDto medicineRequestDto) {
		return dispatcherService.loadMedicione(droneId, medicineRequestDto);
	}
	
	@GetMapping("/check-load/{droneId}")
	public ResponseEntity<ResponseDto<Boolean>> checkLoad(@PathVariable("droneId") BigDecimal droneId) {
		return dispatcherService.checkLoad(droneId);
		
	}
	
	@GetMapping("/get-available-drones")
	public ResponseEntity<ResponseDto<List<DroneDto>>> checkAvailableDrones() {
		return this.dispatcherService.checkAvailableDrones();
	}
	
	@GetMapping("/get-battery-level/{droneId}")
	public ResponseEntity<ResponseDto<Double>> checkBatteryLevel(@PathVariable("droneId") BigDecimal droneId) {
		return this.dispatcherService.checkBatteryLevel(droneId);
	}

}
