package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/find")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers(@RequestParam("name") String name) {
        return ResponseEntity.ok(userRepository.findByName(name));
    }
}
