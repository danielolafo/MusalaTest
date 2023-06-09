package com.test.musala.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.DroneFlight;

@Repository
public interface DroneFlightRepository extends JpaRepository<DroneFlight, BigDecimal>{
	
	public List<DroneFlight> findByDroneId(BigDecimal droneId);
	
	public List<DroneFlight> findByArrivalDate(Date arrivalDate);
	
	//@Query("SELECT df FROM DroneFlight df WHERE df.id = :droneId AND df.arrivalDate IS null")
	//public Optional<DroneFlight> getCurrentDroneFlight(@Param("droneId") BigDecimal droneId);
	
	@Query(value="SELECT * FROM Drone_Flight df  WHERE df.drone_id = ?1 AND df.arrival_Date IS null", nativeQuery=true)
	public Optional<DroneFlight> getCurrentDroneFlight(BigDecimal droneId);

}
