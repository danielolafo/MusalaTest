package com.test.musala.service.impl;

import org.springframework.stereotype.Service;

import com.test.musala.enums.DroneState;

@Service
public class DroneStateServiceImpl {
	
	public DroneState getDroneState(String state) {
		DroneState returnState=null;
		switch(state) {
		case "IDLE":
			returnState = DroneState.IDLE;
			break;
		case "LOADING":
			returnState = DroneState.LOADING;
			break;
		case "LOADED":
			returnState = DroneState.LOADED;
			break;
		case "DELIVERING":
			returnState = DroneState.DELIVERING;
			break;
		case "DEVLIERED":
			returnState = DroneState.DELIVERED;
			break;
		case "RETURNING":
			returnState = DroneState.RETURNING;
			break;
		default:
			break;
		}
		return returnState;
	}

}
