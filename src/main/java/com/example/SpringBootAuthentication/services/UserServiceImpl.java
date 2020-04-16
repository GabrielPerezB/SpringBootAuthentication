package com.example.SpringBootAuthentication.services;

import com.example.SpringBootAuthentication.dao.UserNotPassword;
import com.example.SpringBootAuthentication.dao.UserRepository;
import com.example.SpringBootAuthentication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserNotPassword> findAll(){
        return userRepository.findAllProjectedBy();
    }

    @Override
    public Optional<UserNotPassword> findProjectedByEmail(String email) {
        return userRepository.findProjectedByEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserNotPassword> findById(int id) {
        return userRepository.findProjectedById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
