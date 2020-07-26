package com.vivek.simplemedicinedb.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PrescribedMedicineDto {

	@NotNull(message="medicine dosage_aomunt must not be null")
	private Double dosage_amount;
	
	@NotBlank(message="medicine timings must not be blank or null")
	private String timings;

	@NotNull(message="medicine data must not be null")
	@Valid
	private MedicineDataDto md;

		public Double getDosage_amount() {
		return dosage_amount;
	}

	public void setDosage_amount(Double dosage_amount) {
		this.dosage_amount = dosage_amount;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public MedicineDataDto getMd() {
		return md;
	}

	public void setMd(MedicineDataDto md) {
		this.md = md;
	}
	
}
