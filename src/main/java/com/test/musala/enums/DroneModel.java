package com.test.musala.enums;

public enum DroneModel {
	
	Lightweight("Lightweight"), 
	Middleweight("Middleweight"), 
	Cruiserweight("Cruiserweight"), 
	Heavyweight("Heavyweight");
	
	private String name;
	
	private DroneModel(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	
	

}
