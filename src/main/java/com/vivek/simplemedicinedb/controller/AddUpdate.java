package com.vivek.simplemedicinedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.simplemedicinedb.data.Person;
import com.vivek.simplemedicinedb.data.PrescribedMedicine;
import com.vivek.simplemedicinedb.service.Serve;

@RestController
public class AddUpdate {

	@Autowired
	Serve serve;
	
	@PostMapping(value={"/add/"})
	public Person addUpdate(@RequestBody Person p) {
		return serve.addUpdatePrescription(p);
	}
	
	@GetMapping("/prescriptions")
	public List<PrescribedMedicine> add(@RequestParam("person_id") int person_id) {
		return serve.getPrescriptions(person_id);
	}
	
	
	
}
