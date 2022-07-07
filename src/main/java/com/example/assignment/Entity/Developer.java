package com.example.assignment.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data

public class Developer {
	
	@Id
	@Column(name="did")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	
	@Column(name="dev_name")
	private String name;
	
	@Column(name="dev_email",unique = true)
	private String mail;
	
	@Column(name="dev_phone")
	private String phone;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "assigned_task_to_developer",
            joinColumns = {
                    @JoinColumn(name = "developer_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "task_id") })
                    
	private Set<Task> tasks;  
}
