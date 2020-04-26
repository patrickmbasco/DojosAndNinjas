package com.pbasco.DojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pbasco.DojoNinja.models.Dojo;
import com.pbasco.DojoNinja.repositories.DojoRepository;

@Service
public class DojoServices {
	private final DojoRepository dojoRepository;
	
	public DojoServices(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo singleDojo(Long id) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}

}
