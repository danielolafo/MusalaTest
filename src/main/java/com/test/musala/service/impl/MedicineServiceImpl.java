package com.test.musala.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.musala.dto.MedicineDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.mapper.MedicineMapper;
import com.test.musala.repository.MedicineRepository;
import com.test.musala.service.IMedicineService;

@Service
public class MedicineServiceImpl implements IMedicineService {
	
	private final MedicineRepository medicineRepository;
	
	public MedicineServiceImpl(MedicineRepository medicineRepository) {
		this.medicineRepository=medicineRepository;
	}

	@Override
	public ResponseEntity<ResponseDto<List<MedicineDto>>> checkLoadedMedicine(BigDecimal droneId) {
		String message;
		List<MedicineDto> lstMedicineDto = new ArrayList<>();
		medicineRepository.findCurrentItemsByDrone(droneId).stream()
		.forEach(medicine -> {
			lstMedicineDto.add(MedicineMapper.INSTANCE.entityToDto(medicine));
		});
		message = lstMedicineDto.isEmpty() ? "Drone doesn't exists or doesn't have medicines loaded" : null;
		return new ResponseEntity<>(new ResponseDto<>(lstMedicineDto, message), !lstMedicineDto.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
