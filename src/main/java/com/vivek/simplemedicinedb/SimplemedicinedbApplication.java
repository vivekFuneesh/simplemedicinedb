package com.vivek.simplemedicinedb;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.vivek.simplemedicinedb.dto.MedicineDataDto;
import com.vivek.simplemedicinedb.dto.PersonDto;
import com.vivek.simplemedicinedb.dto.PrescribedMedicineDto;

@SpringBootApplication
public class SimplemedicinedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplemedicinedbApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	public PersonDto getPersonDto() {
		PersonDto p=new PersonDto();
		p.setPrescribed_medicines(new ArrayList<PrescribedMedicineDto>());
		p.getPrescribed_medicines().add(new PrescribedMedicineDto());
		p.getPrescribed_medicines().get(0).setMd(new MedicineDataDto());
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public PrescribedMedicineDto getPresMedDto() {
		PrescribedMedicineDto pmd=new PrescribedMedicineDto();
		pmd.setMd(new MedicineDataDto());
		return pmd;
	}
	
	
}
