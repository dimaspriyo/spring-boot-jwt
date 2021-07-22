package com.example.demo.controller;

import com.example.demo.DTO.request.UserRequest;
import com.example.demo.DTO.response.BaseResponse;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.util.JwtUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    BaseResponse baseResponse = new BaseResponse();

    @PostMapping("/registration")
    public Object registration(@RequestBody UserRequest request) {
        String response = userService.register(request);

        baseResponse.setStatus(true);
        baseResponse.setData(response);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public Object login(@RequestBody UserRequest request) throws Exception {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new NotFoundException("Email Not Found"));
        if (passwordEncoder.encode(request.getPassword()).matches(user.getPassword())) {
            throw new Exception("Login Unsuccessful");
        }
        ;

        baseResponse.setStatus(true);
        baseResponse.setData(jwtUtil.generate(new HashMap<>() {{
            put("email", user.getEmail());
        }}));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping
    public Object getAll() {

        baseResponse.setStatus(true);
        baseResponse.setData(userRepository.findAll());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
