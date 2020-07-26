package com.vivek.simplemedicinedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vivek.simplemedicinedb.service.Serve;

@Controller
public class View {

	@Autowired
	Serve serve;
	
	
	@GetMapping({"/","/home"})
	public String gethome() {
		return "index";
	}

	
	@RequestMapping("/**")
	public void error() throws Exception {
		throw new Exception("BAD URL");
	}
	
}
