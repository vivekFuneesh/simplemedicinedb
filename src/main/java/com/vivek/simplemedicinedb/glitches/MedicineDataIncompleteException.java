package com.vivek.simplemedicinedb.glitches;

public class MedicineDataIncompleteException extends RuntimeException{

	private String name;
	
	public MedicineDataIncompleteException(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
