package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Module;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ModuleRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public List<Module> addModulesToProject(int projectId, List<Module> modules) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            for (Module module : modules) {
                module.setProject(project);
                project.getModules().add(module);
                moduleRepository.save(module);
            }
            projectRepository.save(project);
            return modules;
        } else {
            throw new IllegalArgumentException("Project not found with id: " + projectId);
        }
    }





}
