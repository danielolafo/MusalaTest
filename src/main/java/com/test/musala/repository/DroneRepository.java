package com.test.musala.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, BigDecimal> {

	@Query("SELECT d FROM Drone d WHERE d.state='IDLE'")
	public List<Drone> getAvailableDrones(); 
	
}
