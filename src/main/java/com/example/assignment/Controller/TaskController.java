package com.example.assignment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.Entity.Task;
import com.example.assignment.Repository.TaskRepository;
import com.example.assignment.Response.WebResponse;
import com.example.assignment.Service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired 
	private TaskService tskService;
	
	@Autowired
	private TaskRepository tskRepo;
	
	@PostMapping(value="/Add")
	public ResponseEntity<WebResponse> saveTask (@RequestBody Task tsk){
		boolean status=tskService.saveTask(tsk);
		WebResponse res=new WebResponse(status, tsk);
		return ResponseEntity.ok(res);
	}
	
	

	@GetMapping(value = "/getPending")
	public ResponseEntity<WebResponse> getByPending()
	{
		Optional<Task> opt = tskService.getComplete("pending");
		if(opt.isEmpty())
			return ResponseEntity.badRequest().body(new WebResponse(false, "Hurray! No pending Tasks"));
		else 
		{
			return ResponseEntity.ok(new WebResponse(true, opt.get()));
		}
	}
	@GetMapping(value = "/getCompleted")
	public ResponseEntity<WebResponse> getBycomplete()
	{
		Optional<Task> opt = tskService.getComplete("complete");
		if(opt.isEmpty())
			return ResponseEntity.badRequest().body(new WebResponse(false, "Alas! No task is yet completed"));
		else 
		{
			return ResponseEntity.ok(new WebResponse(true, opt.get()));
		}
	}
	@GetMapping(value = "/getCancel")
	public ResponseEntity<WebResponse> getBycancel()
	{
		Optional<Task> opt = tskService.getCancel("cancel");
		if(opt.isEmpty())
			return ResponseEntity.badRequest().body(new WebResponse(false, "No tasks are cancelled."));
		else 
		{
			return ResponseEntity.ok(new WebResponse(true, opt.get()));
		}
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<WebResponse> updatestatus(@RequestBody String newStatus,String Task_Title) {
		
		 boolean status=tskService.updateStatus(Task_Title,newStatus);
		 WebResponse res=new WebResponse(status, tskRepo.findByTitle(Task_Title));
		 return ResponseEntity.ok(res);
		
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<WebResponse> listTask(){
		List<Task> list=tskService.list();
		WebResponse res=new WebResponse(true, list);
		return ResponseEntity.ok(res);
	}
	
}
