package com.pbasco.DojoNinja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbasco.DojoNinja.models.Ninja;
import com.pbasco.DojoNinja.services.NinjaServices;

@Controller
public class NinjaController {
	private final NinjaServices ninjaServices;
	
	public NinjaController(NinjaServices ninjaServices) {
		this.ninjaServices = ninjaServices;
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObject") Ninja Ninja, Model model) {
		model.addAttribute("dojos", ninjaServices.getAllDojos());
		return "/DojosAndNinjas/newninja.jsp";

	}
	
	@PostMapping("/addninja")
	public String addNinja(@Valid @ModelAttribute("ninjaObject") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/DojosAndNinjas/newninja.jsp";
		}
		else {
			ninjaServices.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId() ;
		}
	}

}
