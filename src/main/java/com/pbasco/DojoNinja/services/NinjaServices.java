package com.pbasco.DojoNinja.services;

import org.springframework.stereotype.Service;

import com.pbasco.DojoNinja.models.Ninja;
import com.pbasco.DojoNinja.repositories.NinjaRepository;

@Service
public class NinjaServices {
	private final NinjaRepository ninjaRepository;
	
	public NinjaServices(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}

	public Object getAllDojos() {
		return ninjaRepository.findAll();

	}
}
