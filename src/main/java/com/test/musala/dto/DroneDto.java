package com.test.musala.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class DroneDto {
	
	private  String serialNumber;
	private String model;
	
	@Max(value=500, message="El peso no puede superar los 500 kg")
	@Min(value=0, message="El peso no puede ser negativo")
	private Double weightLimit;
	
	@Max(value=100)
	@Min(value=0)
	private Double batteryPercentage;
	
	private String state;
	
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
