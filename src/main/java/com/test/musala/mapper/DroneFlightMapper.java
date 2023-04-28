package com.test.musala.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.test.musala.dto.DroneFlightDto;
import com.test.musala.entity.DroneFlight;

@Mapper
public interface DroneFlightMapper {
	
	public DroneFlightMapper INSTANCE = Mappers.getMapper(DroneFlightMapper.class);
	
	public DroneFlightDto entityToDto(DroneFlight droneFlight);
	
	public DroneFlight dtoToEntity(DroneFlightDto droneFlightDto);

}
