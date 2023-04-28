package com.test.musala.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.test.musala.dto.MedicineDto;
import com.test.musala.entity.Medicine;

@Mapper
public interface MedicineMapper {
	
	public MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);
	
	public MedicineDto entityToDto(Medicine medicine);
	
	public Medicine dtoToEntity(MedicineDto medicineDto);

}
