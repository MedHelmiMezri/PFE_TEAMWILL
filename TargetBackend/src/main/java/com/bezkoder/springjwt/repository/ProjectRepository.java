package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Project;



@Repository 
public interface ProjectRepository extends JpaRepository<Project, Integer>{
  
	 
}
