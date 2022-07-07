package com.example.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.Entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
	
	Optional<Developer> findBymail(String email);

}
