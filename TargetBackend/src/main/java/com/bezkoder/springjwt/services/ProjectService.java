package com.bezkoder.springjwt.services;

import java.time.LocalDate;
import java.util.Date;
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


	public List<Project> listAllProjects() {
	        return projectrepo.findAll();
	    }
	 
	 public Project getProjectById(Integer id) {
	        return projectrepo.findById(id).get();
	    }
	 
	  public Project saveProject(Project project) {

		  System.out.println(project.getProjectTitle());
		  messagingTemplate.convertAndSend("/topic/notifications", project);

		  return projectrepo.save(project);
	    }
	  
	  public void deleteProject(Integer id) {
	        projectrepo.deleteById(id);
	    }



	public void addMembersToProject(int projectId, List<String> usernames) {
		    Optional<Project> optionalProject = projectrepo.findById(projectId);

			Project project = optionalProject.get();
			List<User> users = userRepository.findByUsernameIn(usernames);
		    for ( User user:users ) {
				user.setAffectedProject(project);
				project.getMembers().add(user);
				userRepository.save(user);
			}
	         projectrepo.save(project);
	}

}
