package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.Task;
import com.bezkoder.springjwt.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin( "http://localhost:3000")
@RestController
@RequestMapping("/target")
public class TaskController {

    @Autowired
    TaskService taskservice ;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);


    @GetMapping("/show-tasks")
    public List<Task> getAllTasks() {
        return taskservice.getTasks();
    }

    @PostMapping("/add-task/{id}")
    public void saveTask(@PathVariable(value = "id") int taskId ,@RequestBody Task task) {
        taskservice.addTask(taskId , task ) ;
    }

    @PostMapping("/affect-task/{id}")
    public ResponseEntity<Task> addTaskToUser(@PathVariable(value = "id") int taskId, @RequestParam String username) {
        try {
            Task task = taskservice.adduserToTask(taskId , username);
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding team to project: {}", e.getMessage());

            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/resolve-task/{id}")
    public ResponseEntity<Task> resolveTask(@PathVariable int id) {
        try {
            Task task = taskservice.resolveTask(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/close-task/{id}")
    public ResponseEntity<Task> closeTask(@PathVariable int id) {
        try {
            Task task = taskservice.closeTask(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tasks-per-project/{id}")
    public List<Task> getTasks(@PathVariable int id) {
        List<Task> tasks = taskservice.getTasksByProjectId(id) ;
        return tasks ;
    }


    @DeleteMapping("/delete-task/{id}")
    public void deleteT (@PathVariable int id) {
       taskservice.deleteTask(id) ;
       System.out.println("task deleted") ;
    }


    @PutMapping("/updatetaskstatus/{id}/{status}")
    public void  updatetaskstatus(@PathVariable int id , @PathVariable String status) throws Exception {
            taskservice.updatestatus(id , status) ;
    }

}
