package com.bezkoder.springjwt.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String moduleTtile ; 
	
	private String description;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@JsonManagedReference
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task>  tasks = new ArrayList<>();


}
