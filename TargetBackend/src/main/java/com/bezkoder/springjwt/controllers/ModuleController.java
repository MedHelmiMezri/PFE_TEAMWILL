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
    @CrossOrigin
    @PostMapping("/add-module/{projectId}")
    public ResponseEntity<String> addModulesToProject(@PathVariable int projectId, @RequestBody List<Module> modules) {
        moduleService.addModulesToProject(projectId, modules);
        return ResponseEntity.ok("Modules added to project successfully.");
    }


    @CrossOrigin
    @GetMapping("/list-modules")
    @ResponseBody
    public List<Module> listAllModules() {
        List<Module> modules = moduleService.listAllModules();
        return modules ;

    }


}
