package com.test.musala.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.service.IMedicineService;

/**
 * <p>Query all information about medicines</p>
 * 
 * @author Daniel Orlando López Ochoa
 */
@RestController
@RequestMapping("medicine")
@CrossOrigin("*")
public class MedicineController {
	
	private IMedicineService medicineService;
	
	public MedicineController(IMedicineService medicineService) {
		this.medicineService=medicineService;
	}

	@GetMapping("/check-lodaded-medicine/{droneId}")
	public ResponseEntity<ResponseDto<List<MedicineDto>>> checkLoadedMedicine(@PathVariable("droneId")BigDecimal droneId){
		return medicineService.checkLoadedMedicine(droneId);
	}
	
}
