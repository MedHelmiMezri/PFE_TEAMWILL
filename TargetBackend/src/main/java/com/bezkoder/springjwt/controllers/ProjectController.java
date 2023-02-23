package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.services.ProjectService;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/target")
public class ProjectController {


	@Autowired 
    ProjectService projectservice ; 
	
	@CrossOrigin
	@PostMapping("/add-project")
	@ResponseBody
	public void addProject(@RequestBody Project project) {
		projectservice.saveProject(project);
	}
	
	@CrossOrigin
	@GetMapping("/list-projects")
	@ResponseBody
	List<Project> listedProjects(){
		return projectservice.listAllProjects() ; 
	}
	
	@CrossOrigin
	@PostMapping("/detail-project/{id}")
	@ResponseBody
	Project detailProject(@PathVariable("id") int id) {
	 return projectservice.getProjectById(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete-project/{id}")
	@ResponseBody
	public void deleteProject(@PathVariable("id") int id) {
	    projectservice.deleteProject(id);
	}
	
	
	
	
	
	
	
	
	
}
