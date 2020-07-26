package com.vivek.simplemedicinedb.glitches;

public class MedicineDataNotFoundException extends RuntimeException{

	
	private String name;
	
	private String mfg_By;
	
	private String mktd_By;

	
	
	public MedicineDataNotFoundException(String name) {
		super();
		this.name = name;
	}

	public MedicineDataNotFoundException(String name, String mfg_By, String mktd_By) {
		super();
		this.name = name;
		this.mfg_By = mfg_By;
		this.mktd_By = mktd_By;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMfg_By() {
		return mfg_By;
	}

	public void setMfg_By(String mfg_By) {
		this.mfg_By = mfg_By;
	}

	public String getMktd_By() {
		return mktd_By;
	}

	public void setMktd_By(String mktd_By) {
		this.mktd_By = mktd_By;
	}
	
	
	
}
