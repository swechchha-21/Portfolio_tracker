package com.capx.assignmentProject.controllers;

import com.capx.assignmentProject.models.User;
import com.capx.assignmentProject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Endpoint to fetch a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Endpoint to fetch all users
    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userService.getAllUsers();
    }
}
