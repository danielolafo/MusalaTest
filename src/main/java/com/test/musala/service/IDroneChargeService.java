package com.test.musala.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;

public interface IDroneChargeService {
	
	public ResponseEntity<Double> getTotalChargeByFlight(BigDecimal droneFlightId);

	ResponseEntity<ResponseDto<Boolean>> updateCharge(BigDecimal droneId, List<MedicineDto> lstMedicines);

}
