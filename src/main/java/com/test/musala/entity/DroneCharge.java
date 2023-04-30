package com.test.musala.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DroneCharge {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="SEQ_DRONE_CHARGE")
	@SequenceGenerator(name="SEQ_DRONE_CHARGE",sequenceName="SEQ_DRONE_CHARGE", allocationSize=1)
	private BigDecimal id;
	
	@Column(name="drone_flight_id")
	private BigDecimal droneFlightId;
	
	@Column(name="medicine_id")
	private BigDecimal medicineId;
	
	@Column(name="dispatched_amount")
	private Double dispatchedAmount;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}


	public BigDecimal getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(BigDecimal medicineId) {
		this.medicineId = medicineId;
	}

	public Double getDispatchedAmount() {
		return dispatchedAmount;
	}

	public void setDispatchedAmount(Double dispatchedAmount) {
		this.dispatchedAmount = dispatchedAmount;
	}

	public BigDecimal getDroneFlightId() {
		return droneFlightId;
	}

	public void setDroneFlightId(BigDecimal droneFlightId) {
		this.droneFlightId = droneFlightId;
	}
	
	

}
