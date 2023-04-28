package com.test.musala.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DroneCharge {
	
	@Id
	@Column(name="id")
	private BigDecimal id;
	
	@Column(name="drone_id")
	private BigDecimal droneId;
	
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

	public BigDecimal getDroneId() {
		return droneId;
	}

	public void setDroneId(BigDecimal droneId) {
		this.droneId = droneId;
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
