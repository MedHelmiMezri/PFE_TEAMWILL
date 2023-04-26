package com.bezkoder.springjwt.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String projectTitle;
	
	private int budget  ; 
	
	@Column(columnDefinition = "DATE")
	private LocalDate startDate ; 
    
	private String description;
	
	private int duration ; 
	
	private EProjectStatus projectSatus  = EProjectStatus.OnGoing ;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "affected_project_id")
	private List<User> team = new ArrayList<>();


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private User manager;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private List<Module> modules ;



	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private List<Task> tasks ;



}
