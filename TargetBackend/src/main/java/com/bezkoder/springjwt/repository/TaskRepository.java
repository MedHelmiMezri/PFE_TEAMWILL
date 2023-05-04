package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.EtaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Task;

import java.util.List;


@Repository 
public interface TaskRepository extends JpaRepository<Task, Integer>{
    int countByTaskStatus(EtaskStatus taskStatus);

    Task findById(int id) ;


}
