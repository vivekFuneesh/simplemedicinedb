package com.vivek.simplemedicinedb.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class PrescribedMedicine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127707520319571963L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "dosage amount must not be null")
	@Column(name="dosage_amount", nullable = false)
	private Double dosage_amount;

	@NotBlank(message = "timings must not be blank or null")
	@Column(name="timings", nullable = false)
	private String timings;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name="md_id", nullable=false)
	@NotNull
	private MedicineData md;
	

	public PrescribedMedicine() {}

	
	
	public PrescribedMedicine(Integer id,Double dosage_amount,String timings, MedicineData md) {
		super();
		this.id = id;
		this.dosage_amount = dosage_amount;
		this.timings = timings;
		this.md = md;
	}



	public PrescribedMedicine(Double dosage_amount, String timings) {
		super();
		this.dosage_amount = dosage_amount;
		this.timings = timings;
	}
	
	

	public MedicineData getMd() {
		return md;
	}



	public void setMd(MedicineData md) {
		this.md = md;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
