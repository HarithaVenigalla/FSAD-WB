package com.klu.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repo.UserRepo;

@Service
public class UserService {
	private final UserRepo repo;
	public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User register(User user) {
        return repo.save(user);
    }

    public Optional<User> login(String username, String password) {
        return repo.findByUsername(username)
                   .filter(u -> u.getPassword().equals(password));
    }

    public Optional<User> getUser(Long id) {
        return repo.findById(id);
    }

}
