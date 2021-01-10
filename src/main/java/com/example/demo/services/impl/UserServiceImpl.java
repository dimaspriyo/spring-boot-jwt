package com.example.demo.services.impl;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> all() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("User Not Found");
        }

        return user.get();
    }

    @Override
    public User save(User object) {

        return userRepository.save(object);
    }

    @Override
    public void delete(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new Exception("User Not Found");
        }

        return user.get();
    }
}