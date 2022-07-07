package com.example.assignment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.Entity.Task;
import com.example.assignment.Repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository tskRepo;
	
	public boolean saveTask(Task tsk) {

		try {
			tskRepo.save(tsk);
			tskRepo.flush();
			return true;
		} catch (Exception e) {
			System.out.println("Oops! Data could not be saved because of " + e.getMessage());
			return false;
		}

	}
	public List<Task> list(){
		return tskRepo.findAll();
	}
	
	public Optional<Task> getComplete(String val){
		return tskRepo.findByStatus(val);
	}
	public Optional<Task> getPending(String val){
		return tskRepo.findByStatus(val);
	}
	public Optional<Task> getCancel(String val){
		return tskRepo.findByStatus(val);
	}
	
	public boolean updateStatus(String taskName,String newStatus) {
		
		try{
			Task tsk=tskRepo.findByTitle(taskName);
		
		tsk.setStatus(newStatus);
		tskRepo.save(tsk);
		
		return true;
		}
		catch(Exception e) {
			System.out.println("No task with the name is found");
			return false;
		}
	}

}
