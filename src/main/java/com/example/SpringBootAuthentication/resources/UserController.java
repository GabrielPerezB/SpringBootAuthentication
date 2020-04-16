package com.example.SpringBootAuthentication.resources;

import com.example.SpringBootAuthentication.entity.User;
import com.example.SpringBootAuthentication.models.AuthenticationRequest;
import com.example.SpringBootAuthentication.models.AuthenticationResponse;
import com.example.SpringBootAuthentication.services.MyUserDetailsService;
import com.example.SpringBootAuthentication.services.UserServiceImpl;
import com.example.SpringBootAuthentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @GetMapping("/users")
    public List<User> listUsers(){
        return userServiceImpl.findAll();
    }

    @GetMapping("/users/id/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        Optional<User> user = userServiceImpl.findById(id);
        if (user == null){
            throw new RuntimeException("Employee is not found - " + user);
        }
        return user;
    }


    @GetMapping("/users/email/{email}")
    public Optional<User> userByEmail(@PathVariable String email){
        Optional<User> user = userServiceImpl.findByEmail(email);
        if (user == null){
            throw new RuntimeException("Employee is not found - " + user);
        }
        return user;
    }

    @PostMapping("/users")
    public User addEmployee(@RequestBody User user){
        user.setId(0);
        userServiceImpl.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateEmployee(@RequestBody User user){
        userServiceImpl.save(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String updateEmployee(@PathVariable int id){
        Optional<User> tempUser = userServiceImpl.findById(id);

        if(tempUser == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        userServiceImpl.deleteById(id);
        return "Deleted employee id - " + id;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
