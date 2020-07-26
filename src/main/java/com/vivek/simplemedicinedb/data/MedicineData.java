package com.vivek.simplemedicinedb.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class MedicineData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = "mfg_By", nullable = false)
	private String mfg_By;
	
	@NotBlank
	@Column(name="mktd_By", nullable = false)
	private String mktd_By;
	
	@NotBlank
	@Column(nullable = false)
	private String chemicals; 
	
	@Column(name = "any_other_note")
	private String any_other_note;


	public MedicineData() {}
	
	
	public MedicineData(String name, String mfg_By, String mktd_By, String chemicals, String any_other_note) {
		super();
		this.name = name;
		this.mfg_By = mfg_By;
		this.mktd_By = mktd_By;
		this.chemicals = chemicals;
		this.any_other_note = any_other_note;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
