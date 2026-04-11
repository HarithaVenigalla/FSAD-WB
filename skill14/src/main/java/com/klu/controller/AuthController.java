package com.klu.controller;

import com.klu.model.User;
import com.klu.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) { this.service = service; }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> u = service.login(user.getUsername(), user.getPassword());
        return u.orElse(null);
    }

    @GetMapping("/profile/{id}")
    public User profile(@PathVariable Long id) {
        Optional<User> u = service.getUser(id);
        return u.orElse(null);
    }
}