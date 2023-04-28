package com.test.musala.dto;

public class ResponseDto<T> {
	
	private T data;
	private String message;
	
	public ResponseDto(T data) {
		this.data=data;
	}
	
	public ResponseDto(T data, String message) {
		this.data=data;
		this.message=message;
	}
	
	public T getData() {
		return this.data;
	}
	
	public String getMessage() {
		return this.message;
	}

}
