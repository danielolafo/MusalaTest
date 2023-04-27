package com.test.musala.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, BigDecimal> {

	//public Optional<Drone> 
	
}
