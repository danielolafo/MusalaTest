package com.test.musala.dto;

import com.test.musala.enums.DroneModel;
import com.test.musala.enums.DroneState;

public class DroneDto {
	
	private  String serialNumber;
	private String model;
	private Double weightLimit;
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
