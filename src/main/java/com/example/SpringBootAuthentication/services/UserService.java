package com.example.SpringBootAuthentication.services;

import com.example.SpringBootAuthentication.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();

    public Optional<User> findByEmail(String email);

    public Optional<User> findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
