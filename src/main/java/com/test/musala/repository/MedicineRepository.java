package com.test.musala.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.musala.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, BigDecimal>{
	
	@Query(value="SELECT m.* FROM Medicine m JOIN DroneCharge dc ON m.id=dc.medicine_id JOIN DroneFlight df ON dc.drone_Flight_Id=df.id WHERE df.drone_id = ?1 AND df.arrival_date IS NULL", nativeQuery=true)
	public List<Medicine> findCurrentItemsByDrone(BigDecimal droneId);

}
