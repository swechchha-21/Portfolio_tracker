package com.capx.assignmentProject.services;

import com.capx.assignmentProject.models.User;
import com.capx.assignmentProject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to fetch a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Method to get all users
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
