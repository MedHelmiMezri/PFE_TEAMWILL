package com.bezkoder.springjwt.controllers;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.repository.GantLinksRepository;
import com.bezkoder.springjwt.repository.GanttasksRepository;



import com.bezkoder.springjwt.models.Gantlinks;
import com.bezkoder.springjwt.models.Ganttasks;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class GanttController {
    @Autowired
    GantLinksRepository gantlinksrepo;

    @Autowired
    GanttasksRepository ganttasksrepo;


    @GetMapping("/data")
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

    //    @PostMapping(
//            path = "/data/task",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public void addTask(@RequestBody Ganttasks gantttask) {
//            ganttasksrepo.save(gantttask) ;
//    }


}
   
   


