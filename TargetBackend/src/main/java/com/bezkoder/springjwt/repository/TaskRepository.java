package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.EtaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Task;


@Repository 
public interface TaskRepository extends JpaRepository<Task, Integer>{
    int countByTaskStatus(EtaskStatus taskStatus);


}
