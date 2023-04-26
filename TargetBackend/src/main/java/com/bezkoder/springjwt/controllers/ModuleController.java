package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Module;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/target")
public class ModuleController {


    @Autowired
    ModuleService moduleService ;


}
