package com.bezkoder.springjwt.security.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ProjectRepository;

@Service
public class ProjectService {
	
	
	@Autowired 
	ProjectRepository projectrepo ; 
	
	
	 public List<Project> listAllProjects() {
	        return projectrepo.findAll();
	    }
	 
	 public Project getProjectById(Integer id) {
	        return projectrepo.findById(id).get();
	    }
	 
	  public Project saveProject(Project project) {
		  System.out.println("Sdate project = "+project.getStartDate());
	      return projectrepo.save(project);
	    }
	  
	  public void deleteProject(Integer id) {
	        projectrepo.deleteById(id);
	    }
	  
	
	

}
