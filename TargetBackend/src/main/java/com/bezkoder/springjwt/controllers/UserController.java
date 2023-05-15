package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/target")

public class UserController {


    @Autowired
    UserRepository userrepository ;

    @Autowired
    RoleRepository rolerepository ;

    @PutMapping("/permission/{id}")
    public ResponseEntity<User> updateUserRole(@PathVariable("id") Long id) {
        User user = userrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.getRoles().removeIf(role -> role.getName().equals("ROLE_INACTIVE"));
        Role userRole = rolerepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.getRoles().add(userRole);
        User updatedUser = userrepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/all-users")
    public List<User> GetAllUsers() {
       List<User> userlist = userrepository.findAll() ;
       return userlist ;
     }



}
