package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.EtaskStatus;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.models.Task;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.ProjectRepository;
import com.bezkoder.springjwt.repository.TaskRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Level;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskrepository;

    @Autowired
    UserRepository userrepository;

    @Autowired
    ProjectRepository projectRepository ;

    //////////////////////////////////////////// add a task to a user by his given id !!!!!!!!!!!!!!

    public void addTask (int projectId,Task task ) {
        try {
            Project project = projectRepository.findById(projectId) ;
            project.getTasks().add(task);
            taskrepository.save(task);
            projectRepository.save(project);

        } catch (Exception e) {
            System.out.println(e) ;
        }
    }

    public List<Task> getTasks () {
        return taskrepository.findAll()  ;
    }


    public Task adduserToTask(int taskId, String username) throws Exception {
        Task task = taskrepository.findById(taskId) ;
        User user = null;
        try {
            user = userrepository.findUsername(username);
            if (user == null) {
                // log the error
                throw new Exception("User not found");
            } else {
                task.setAffectedUser(user);
                taskrepository.save(task);
                return task;
            }
        } catch (Exception e) {
            // log the error
            throw e;
        }

    }


    public Task resolveTask(int id ) throws Exception {
        Task task = taskrepository.findById(id);
        try {
            task.setTaskStatus(EtaskStatus.backlog);
            taskrepository.save(task);
            return task ;
        }catch(Exception e ) {
            throw e  ;
        }
    }

    public Task closeTask(int id ) throws Exception {
        Task task = taskrepository.findById(id) ;
        try {
            task.setTaskStatus(EtaskStatus.backlog);
            taskrepository.save(task);
            return task ;
        }catch(Exception e ) {
            throw e  ;
        }
    }


    public List<Task> showTasks() {
        return taskrepository.findAll() ;
    }
    public void AddAffectTask(String username , String projectname , Task task) throws Exception {
        User user = userrepository.findUsername(username) ;
        Project project = projectRepository.findByProjectTitle(projectname ) ;
        try {
           project.getTasks().add(task) ;
           task.setAffectedUser(user);
           taskrepository.save(task) ;
           projectRepository.save(project) ;
        } catch (Exception e ) {
            throw e ;
        }
    }


    public void updateTaskState (int id , String status ) throws Exception {
        Task task = taskrepository.findById(id);
    }

    public List<Task> getTasksByProjectId(int projectId) {

        Project project = projectRepository.findById(projectId) ;

        return project.getTasks();
    }
     public void deleteTask(int id ) {
        taskrepository.deleteById(id);
     }

    public void updatestatus(int id , String status ) throws Exception {

        Task task = taskrepository.findById(id);

        try {
            switch(status){
                case "backlog" :
                    task.setTaskStatus(EtaskStatus.backlog) ;
                    break ;
                case "inprogress" :
                    task.setTaskStatus(EtaskStatus.inprogress);
                    break ;
                case "test" :
                    task.setTaskStatus(EtaskStatus.test);
                    break ;
                case "done" :
                    task.setTaskStatus(EtaskStatus.done); }
            taskrepository.save(task);

        }catch(Exception e ) {
            throw e  ;
        }
    }
}
