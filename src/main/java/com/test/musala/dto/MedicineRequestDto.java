package com.test.musala.dto;

import java.math.BigDecimal;
import java.util.List;

public class MedicineRequestDto {
	
	private BigDecimal droneId;
	private String origin;
	private String target;
	private List<MedicineDto> lstMedicines;
	
	public BigDecimal getDroneId() {
		return droneId;
	}
	public void setDroneId(BigDecimal droneId) {
		this.droneId = droneId;
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
	public List<MedicineDto> getLstMedicines() {
		return lstMedicines;
	}
	public void setLstMedicines(List<MedicineDto> lstMedicines) {
		this.lstMedicines = lstMedicines;
	}
	
	

}
