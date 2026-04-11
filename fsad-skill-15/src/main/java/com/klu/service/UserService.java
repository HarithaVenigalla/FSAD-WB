package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Add User
    public User addUser(User user) {
        return repo.save(user);
    }

    // Get User by ID
    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Get all users
    public java.util.List<User> getAllUsers() {
        return repo.findAll();
    }

    // Delete user
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    // Update user
    public User updateUser(Long id, User newUser) {
        User user = repo.findById(id).orElse(null);

        if (user != null) {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return repo.save(user);
        }
        return null;
    }
}