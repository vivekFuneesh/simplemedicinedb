package com.vivek.simplemedicinedb.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PersonDto {

	@NotBlank(message="person/patient name must not be blank or null")
	private String name;
	
	@NotBlank(message="phone must not be blank or null")
	@Size(min=10, max=10, message="phone must not be blank or null")
	private String phone;
	
	@NotNull(message="prescriptions list must not be null")
	private Set<@Valid PrescribedMedicineDto> prescribed_medicines ;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<PrescribedMedicineDto> getPrescribed_medicines() {
		return prescribed_medicines;
	}

	public void setPrescribed_medicines(Set<PrescribedMedicineDto> prescribed_medicines) {
		this.prescribed_medicines = prescribed_medicines;
	}

	
	
}
