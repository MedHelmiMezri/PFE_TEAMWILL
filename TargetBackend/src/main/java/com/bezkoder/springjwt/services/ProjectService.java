package com.bezkoder.springjwt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ProjectRepository;

@Service
public class ProjectService {
	
	
	@Autowired 
	ProjectRepository projectrepo ;
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	UserRepository userRepository ;

	public List<Project> getAllProjects () {
		return projectrepo.findAll()  ;
	}

	public Project addProject(Project project) {
		projectrepo.save(project) ;
		return project;
	}


	public Project getProductById(int id) {
		return projectrepo.findById(id).orElse(null);
	}

	public void deleteProject(int id ) {
		projectrepo.deleteById(id);
	}


	public Project addTeamToProject(int projectId, List<String> usernames) throws Exception {
		Project project = projectrepo.findById(projectId).orElseThrow(() -> new Exception("Project not found"));
		List<User> team = new ArrayList<>();
		for (String username : usernames) {
			Optional<User> userOptional = userRepository.findByUsername(username);
			userOptional.ifPresent(team::add);
		}
		project.setTeam(team);
		return projectrepo.save(project);
	}




}
