package com.vivek.simplemedicinedb.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4081476397742654214L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="name must not be blank or null")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message="must not be blank or null")
	@Pattern(regexp = "\\d+" , message="must be numbers only")
	@Size(min=10, max=10, message="length of phone number must be 10")
	@Column(nullable = false)
	private String phone;
	
	@OneToMany(targetEntity = PrescribedMedicine.class, orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@JoinColumn(name="pm_pfk", referencedColumnName = "id")
	@NotNull(message = "List must not be null or empty")
	private List<@NotNull(message = "entry in list must not ne null or empty") PrescribedMedicine> prescribed_medicines ;

	public Person() {}

	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	} 

	
	public Person(String name, String phone, ArrayList<PrescribedMedicine> prescribed_medicines) {
		super();
		this.name = name;
		this.phone = phone;
		this.prescribed_medicines = prescribed_medicines;
	}

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

	public List<PrescribedMedicine> getPrescribed_medicines() {
		return prescribed_medicines;
	}

	public void setPrescribed_medicines(List<PrescribedMedicine> prescribed_medicines) {
		this.prescribed_medicines = prescribed_medicines;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
