package com.vivek.simplemedicinedb.glitches;

public class PrescriptionsError {

	private Integer code;
	private String message;
	
	
	public PrescriptionsError(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
