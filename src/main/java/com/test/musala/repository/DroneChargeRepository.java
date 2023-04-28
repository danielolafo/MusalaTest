package com.test.musala.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.DroneCharge;

@Repository
public interface DroneChargeRepository extends JpaRepository<DroneCharge, BigDecimal>{
	
	@Query("SELECT dc FROM DroneCharge dc WHERE dc.droneFlightId = :droneFlightId")
	public List<DroneCharge> findByDroneFlightId(BigDecimal droneFlightId);

}
