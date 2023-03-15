package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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





@CrossOrigin( "http://localhost:3000")
@RestController
@RequestMapping("/target")
public class ProjectController {



	@Autowired 
    ProjectService projectservice ;

	@PostMapping("/add-project")
	@ResponseBody
	public void addProject(@RequestBody Project project) {
		projectservice.saveProject(project);
	}

	@GetMapping("/list-projects")
	@ResponseBody
	public List<Project> listAllProjects() {
		List<Project> projects = projectservice.listAllProjects();
		return projects ;

	}

	@GetMapping("/detail-project/{id}")
	@ResponseBody
	Project detailProject(@PathVariable("id") int id) {
	 return projectservice.getProjectById(id);
	}

	@DeleteMapping("/delete-project/{id}")
	@ResponseBody
	public void deleteProject(@PathVariable("id") int id) {
	    projectservice.deleteProject(id);
	}

	@PostMapping("/members/{id}")
	public ResponseEntity<String> addMembersToProject(@PathVariable("id") int projectId, @RequestBody List<String> usernames) {
		try {
			projectservice.addMembersToProject(projectId, usernames);
			return ResponseEntity.ok().body("Members added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding members");
		}
	}



	
	
	
}
