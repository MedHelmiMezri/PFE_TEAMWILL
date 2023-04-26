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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





@CrossOrigin( "http://localhost:3000")
@RestController
@RequestMapping("/target")
public class ProjectController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	@Autowired 
    ProjectService projectservice ;



    @GetMapping("/show-projects")
    public List<Project> getAllProjects() {
        return projectservice.getAllProjects();
    }


    @PostMapping("/add-project")
    public Project saveProjectt(@RequestBody Project project) {
        return projectservice.addProject(project);
    }

    @PostMapping("/add-team/{id}")
    public ResponseEntity<Project> addTeamToProject(@PathVariable(value = "id") int projectId, @RequestBody List<String> usernames) {
        try {
            Project project = projectservice.addTeamToProject(projectId, usernames);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding team to project: {}", e.getMessage());

            return ResponseEntity.notFound().build();
        }
    }












}
