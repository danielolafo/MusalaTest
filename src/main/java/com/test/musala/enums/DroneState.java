package com.test.musala.enums;

import java.math.BigDecimal;

public enum DroneState {
	
	IDLE(BigDecimal.valueOf(1),"IDLE"), 
	LOADING(BigDecimal.valueOf(2),"LOADING"), 
	LOADED(BigDecimal.valueOf(3),"LOADED"), 
	DELIVERING(BigDecimal.valueOf(4),"DELIVERING"), 
	DELIVERED(BigDecimal.valueOf(5),"DELIVERED"), 
	RETURNING(BigDecimal.valueOf(6),"RETURNING");
	
	private DroneState(BigDecimal code, String name) {
		this.stateCode = code;
		this.stateName=name;
	}
	
	private BigDecimal stateCode;
	private String stateName;
	
	public BigDecimal getStateCode() {
		return stateCode;
	}
	public void setStateCode(BigDecimal stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
}
