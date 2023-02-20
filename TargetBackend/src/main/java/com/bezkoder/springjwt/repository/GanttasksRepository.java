package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Ganttasks;
import com.bezkoder.springjwt.models.User;

@Repository
public interface GanttasksRepository extends JpaRepository<Ganttasks,Integer>{
	

}
