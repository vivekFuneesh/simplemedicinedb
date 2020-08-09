package com.vivek.simplemedicinedb.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.simplemedicinedb.dto.PersonDto;
import com.vivek.simplemedicinedb.service.Serve;

@RestController
@Validated
public class AddUpdate {

	@Autowired
	Serve serve;
	
	@PostMapping(value={"/rest/add/"})
	public PersonDto addUpdate( @Valid PersonDto p, BindingResult br) {
		
		return serve.addUpdatePrescription(p);
	}
	
	@GetMapping("/rest/prescriptions")
	public PersonDto get(@RequestParam("phone") @NotBlank String phone) {
			return serve.getPrescriptions(phone);
	}
	
	
}
