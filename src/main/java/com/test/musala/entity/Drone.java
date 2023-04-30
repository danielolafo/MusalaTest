package com.test.musala.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Drone {
    
	@Id
	@GeneratedValue(generator="SEQ_DRONE")
	@SequenceGenerator(name="SEQ_DRONE",sequenceName="SEQ_DRONE", allocationSize=1)
	@Column(name="id")
	private BigDecimal id;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="model")
	private String model;
	
	@Column(name="weight_limit")
	private Double weightLimit;
	
	@Column(name="battery_percentage")
	private Double batteryPercentage;
	
	@Column(name="state")
	private String state;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(Double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public Double getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(Double batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
