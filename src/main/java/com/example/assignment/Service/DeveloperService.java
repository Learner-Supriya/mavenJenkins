package com.example.assignment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.Entity.Developer;
import com.example.assignment.Repository.DeveloperRepository;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRepository devRepo;

	public boolean saveDevloper(Developer dev) {

		try {
			devRepo.save(dev);
			devRepo.flush();
			return true;
		} catch (Exception e) {
			System.out.println("Oops! Data could not be saved because of " + e.getMessage());
			return false;
		}

	}
	public List<Developer> list(){
		return devRepo.findAll();
	}
	
	public Optional<Developer> get(String email){
		return devRepo.findBymail(email);
	}
	
	
	
	

}
