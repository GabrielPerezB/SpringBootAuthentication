package com.example.SpringBootAuthentication.services;

import com.example.SpringBootAuthentication.dao.UserNotPassword;
import com.example.SpringBootAuthentication.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserNotPassword> findAll();

    public Optional<User> findByEmail(String email);

    public Optional<UserNotPassword> findProjectedByEmail(String email);

    public Optional<UserNotPassword> findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
