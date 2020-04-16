package com.example.SpringBootAuthentication.dao;

import com.example.SpringBootAuthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<UserNotPassword> findProjectedByEmail(String email);
    public Optional<UserNotPassword> findProjectedById(int id);
    public List<UserNotPassword> findAllProjectedBy();
}
