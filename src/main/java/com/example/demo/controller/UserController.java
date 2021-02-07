package com.example.demo.controller;

import com.example.demo.DTO.request.UserRequest;
import com.example.demo.DTO.response.BaseResponse;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    BaseResponse baseResponse = new BaseResponse();

    @PostMapping("/registration")
    public Object registration(@RequestBody UserRequest request) {
       String response =  userService.register(request);

       baseResponse.setStatus(true);
       baseResponse.setData(response);
       return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);

    }

}
