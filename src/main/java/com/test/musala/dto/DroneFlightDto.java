package com.test.musala.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class DroneFlightDto {

	private BigDecimal id;

	private Date dispatchedDate;
	
	private Date arrivalDate;

	private String origin;

	private String target;

	private String observations;
	
	private BigDecimal droneId;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getDispatchedDate() {
		return dispatchedDate;
	}

	public void setDispatchedDate(Date dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public BigDecimal getDroneId() {
		return droneId;
	}

	public void setDroneId(BigDecimal droneId) {
		this.droneId = droneId;
	}
	
	

}
