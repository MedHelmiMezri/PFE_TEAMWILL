package com.bezkoder.springjwt.controllers;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.repository.GantLinksRepository;
import com.bezkoder.springjwt.repository.GanttasksRepository;



import com.bezkoder.springjwt.models.Gantlinks;
import com.bezkoder.springjwt.models.Ganttasks;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/api/")
public class GanttController {
   @Autowired
   GantLinksRepository gantlinksrepo ; 
   
   @Autowired
   GanttasksRepository ganttasksrepo ; 


     @GetMapping("auth/data")
     public ResponseEntity<Map<String, Object>> getData() {
       try {
         List<Ganttasks> tasks = ganttasksrepo.findAll();
           val links = gantlinksrepo.findAll();
 
         Map<String, Object> response = new HashMap<>();
         response.put("data", tasks);
         Map<String, List> collections = new HashMap<>();
         collections.put("links", links);
         response.put("collections", collections);

         return ResponseEntity.ok(response);
       } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
     }
     
     
     
     
     
     
   }

  
   
   
   


