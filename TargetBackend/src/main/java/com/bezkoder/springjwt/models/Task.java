package com.bezkoder.springjwt.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Task {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String titreTache ; 
	
	private ETypeTask typeTask ;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date starstDate;
		
	private int taskduration  ; 
	
	private EPriorityTask priorityTask  ; 
	
	private EtaskStatus taskStatus = EtaskStatus.Pending ;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Module module;



}
