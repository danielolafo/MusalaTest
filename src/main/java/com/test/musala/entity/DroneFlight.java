package com.test.musala.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DroneFlight {
	
	@Id
	@Column(name="id")
	private BigDecimal id;
	
	@Column(name="dispatched_date")
	private Date dispatchedDate;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="target")
	private String target;
	
	@Column(name="observations")
	private String observations;

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
	
	

}
