package com.vivek.simplemedicinedb.dto;

import javax.validation.constraints.NotBlank;

public class MedicineDataDto {
	
	@NotBlank(message="medicine name must not be blank or null")
	private String name;
	
	private String mfg_By;
	
	private String mktd_By;
	
	private String chemicals; 
	
	private String any_other_note;

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

	public String getChemicals() {
		return chemicals;
	}

	public void setChemicals(String chemicals) {
		this.chemicals = chemicals;
	}

	public String getAny_other_note() {
		return any_other_note;
	}

	public void setAny_other_note(String any_other_note) {
		this.any_other_note = any_other_note;
	}



}
