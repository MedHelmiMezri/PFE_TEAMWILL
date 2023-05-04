package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.EtaskStatus;
import com.bezkoder.springjwt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/target")
public class DashboardController {

    @Autowired
    TaskRepository taskRepository ;
    @GetMapping("/task-counts")
    public Map<String, Integer> getTaskCounts() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Pending", taskRepository.countByTaskStatus(EtaskStatus.backlog));
        counts.put("Resolved", taskRepository.countByTaskStatus(EtaskStatus.backlog));
        counts.put("Closed", taskRepository.countByTaskStatus(EtaskStatus.backlog));
        return counts;
    }
}
