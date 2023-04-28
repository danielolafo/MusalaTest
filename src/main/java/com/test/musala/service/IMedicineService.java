package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;

public interface IMedicineService {
	
	ResponseEntity<ResponseDto<List<MedicineDto>>> checkLoadedMedicine(BigDecimal droneId);

}
