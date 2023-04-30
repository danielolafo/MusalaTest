package com.test.musala.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(generator="SEQ_MEDICINE")
	@SequenceGenerator(name="SEQ_MEDICINE",sequenceName="SEQ_MEDICINE", allocationSize=1)
	@Column(name="id")
	private BigDecimal id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="code")
	private String code;
	
	@Column(name="image")
	private byte[] image;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

}
