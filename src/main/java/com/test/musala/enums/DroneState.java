package com.test.musala.enums;

import java.math.BigDecimal;

public enum DroneState {
	
	IDLE(BigDecimal.valueOf(1),"IDLE"){
		
		@Override
		public DroneState nextState() {
			return LOADING;
		}
	}, 
	LOADING(BigDecimal.valueOf(2),"LOADING"){
		
		@Override
		public DroneState nextState() {
			return LOADED;
		}
	}, 
	LOADED(BigDecimal.valueOf(3),"LOADED"){
		
		@Override
		public DroneState nextState() {
			return DELIVERING;
		}
	}, 
	DELIVERING(BigDecimal.valueOf(4),"DELIVERING"){
		
		@Override
		public DroneState nextState() {
			return DELIVERED;
		}
	}, 
	DELIVERED(BigDecimal.valueOf(5),"DELIVERED"){
		
		@Override
		public DroneState nextState() {
			return RETURNING;
		}
	}, 
	RETURNING(BigDecimal.valueOf(6),"RETURNING"){
		
		@Override
		public DroneState nextState() {
			return IDLE;
		}
	};
	
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
	
	public abstract DroneState nextState();
	
	
}
