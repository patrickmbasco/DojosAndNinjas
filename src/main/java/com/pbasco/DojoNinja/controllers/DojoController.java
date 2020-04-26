package com.pbasco.DojoNinja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbasco.DojoNinja.models.Dojo;
import com.pbasco.DojoNinja.services.DojoServices;

@Controller
public class DojoController {
	private final DojoServices dojoServices;
	
	public DojoController(DojoServices dojoServices) {
		this.dojoServices = dojoServices;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojoObject") Dojo dojo) {
		return "/DojosAndNinjas/newdojo.jsp";

	}
	
	@PostMapping("/adddojo")
	public String addDojo(@Valid @ModelAttribute("dojoObject") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/DojosAndNinjas/newdojo.jsp";
		}
		else {
			dojoServices.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId") long id, Model model) {
		Dojo dojo = dojoServices.singleDojo(id);
		model.addAttribute("dojo", dojo);
		return "/DojosAndNinjas/show.jsp";
	}
}
