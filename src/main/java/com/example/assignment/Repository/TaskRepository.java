package com.example.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.assignment.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	Optional<Task> findByStatus(String val);

	Task findByTitle(String taskName);
	
	

}
