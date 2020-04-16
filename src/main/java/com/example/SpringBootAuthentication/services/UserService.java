package com.example.SpringBootAuthentication.services;

import com.example.SpringBootAuthentication.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
}
