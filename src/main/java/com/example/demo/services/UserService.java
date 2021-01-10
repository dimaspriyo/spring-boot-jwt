package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService extends BaseService<User>{

    User findByEmail(String email) throws Exception;

}
