package com.example.assignment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.Entity.Developer;
import com.example.assignment.Response.WebResponse;
import com.example.assignment.Service.DeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	
	@Autowired
	private DeveloperService devService;
	
	@PostMapping(value="/Add")
	public ResponseEntity<WebResponse> saveDeveloper (@RequestBody Developer dev){
		boolean status=devService.saveDevloper(dev);
		WebResponse res=new WebResponse(status, dev);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping(value = "/get/{mail}")
	public ResponseEntity<WebResponse> getByMail(@PathVariable(value = "mail") String email)
	{
		Optional<Developer> opt = devService.get(email);
		if(opt.isEmpty())
			return ResponseEntity.badRequest().body(new WebResponse(false, "Developer with the given emailid is mot found !"));
		else 
		{
			return ResponseEntity.ok(new WebResponse(true, opt.get()));
		}
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<WebResponse> listDeveloper(){
		List<Developer> list=devService.list();
		WebResponse res=new WebResponse(true, list);
		return ResponseEntity.ok(res);
	}
	

}
