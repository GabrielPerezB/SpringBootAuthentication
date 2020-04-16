package com.example.SpringBootAuthentication.dao;

import com.example.SpringBootAuthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
