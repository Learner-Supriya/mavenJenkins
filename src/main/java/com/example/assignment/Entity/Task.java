package com.example.assignment.Entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data

public class Task {
	
	@Id
	@Column(name="tid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	
	@Column(name="tsk_title")
	private String title;
	
	@Column(name="tsk_desc")
	private String description;
	
	@Column(name="tsk_status")
	private String status;
	
	@ManyToMany(mappedBy="tasks")
	private Set<Developer> developers;
}
