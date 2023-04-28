package com.test.musala.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.DroneFlight;

@Repository
public interface DroneFlightRepository extends JpaRepository<DroneFlight, BigDecimal>{
	
	public List<DroneFlight> findByDroneId(BigDecimal droneId);
	
	public List<DroneFlight> findByArrivalDate(Date arrivalDate);
	
	@Query("SELECT df FROM DroneFlight df WHERE df.id = :droneId AND df.arrivalDate = null")
	public Optional<DroneFlight> getCurrentDroneFlight(BigDecimal droneId);

}
