package com.vivek.simplemedicinedb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {

	@GetMapping({"/","/home"})
	public String gethome(Model model) {
		model.addAttribute("result","HI");
		return "index";
	}

	
}
