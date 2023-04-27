package com.test.musala.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.test.musala.dto.DroneDto;
import com.test.musala.entity.Drone;

@Mapper
public interface DroneMapper {
	
	public DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);
	
	public DroneDto entityToDto(Drone drone);
	
	public Drone dtoToEntity(DroneDto droneDto);

}
