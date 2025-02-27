package com.cct.assignment.datasetProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cct.assignment.datasetProject.model.User;
import com.cct.assignment.datasetProject.repository.UserRepository;


@Controller
@RequestMapping("/")
public class LoginController {
	
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            // User found, login successful
            return "redirect:/crudoperations"; 
        } else {
            // Invalid credentials, login failed
            return "redirect:/?error"; // Redirect to the login page with an error parameter
        }
    }
}
