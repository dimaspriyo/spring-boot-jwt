package com.example.demo.services.impl;

import com.example.demo.entities.User;
import com.example.demo.entities.UserPrincipal;
import com.example.demo.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> myUser = userRepository.findByEmail(username);
        if (myUser.isEmpty()){
            throw new UsernameNotFoundException("User Not Found");
        }

        return new UserPrincipal(myUser.get());


    }
}
