package com.vivek.simplemedicinedb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivek.simplemedicinedb.dto.MedicineDataDto;
import com.vivek.simplemedicinedb.dto.PersonDto;
import com.vivek.simplemedicinedb.dto.PrescribedMedicineDto;
import com.vivek.simplemedicinedb.service.Serve;

@Controller
@Validated
public class View {

	@Autowired
	Serve serve;
	
	@Autowired
	ApplicationContext ac;
	
	
	@GetMapping({"/","/home"})
	public String gethome(Model model) {

		PersonDto p=ac.getBean(PersonDto.class);
		model.addAttribute("person",p);
		return "index";
	}


	@PostMapping("/addPrescribedMedicineRow")
	public String addMedicineDataRow(@ModelAttribute("person") PersonDto personDto, BindingResult br) {
		System.out.println("Inside add row"+ br.hasErrors());
		if(personDto==null) {
			personDto=ac.getBean(PersonDto.class);
		}
		personDto.getPrescribed_medicines().add(0,ac.getBean(PrescribedMedicineDto.class));
		
		return "index";
	}
	
	
	@PostMapping("/deletePrescribedMedicineRow")
	public String deleteMedicineDataRow(@ModelAttribute("person") PersonDto personDto, @RequestParam("delete") Integer deleteIndex, BindingResult br) {
	
		System.out.println("Inside DELETE row"+" "+ br.hasErrors()+" "+deleteIndex);

		personDto.getPrescribed_medicines().remove(deleteIndex.intValue());
		
		return "index";
	}
	
	
	@GetMapping("/view/prescriptions")
	public String get(Model model, @RequestParam("phone") @NotBlank String phone) {
			model.addAttribute("personPresc",serve.getPrescriptions(phone));
			System.out.println(((PersonDto)model.getAttribute("personPresc")).getName());
			model.addAttribute("person",ac.getBean(PersonDto.class));
			return "index";
	}
	
	@PostMapping(value={"/view/add/"})
	public String addUpdate(Model model,  @Valid PersonDto p, BindingResult br) {
		model.addAttribute("person",serve.addUpdatePrescription(p));
		return "index";
	}
	
	
	@RequestMapping("/error/**")
	public void error() throws Exception {
		throw new Exception("BAD URL");
	}
	
}
