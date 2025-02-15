package com.example.Instagram.controller;

import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.UserModel;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user) ;
        return ResponseEntity.ok(createdUser) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable UUID id) {
        Optional<UserEntity> user  = userService.getUserById(id) ;
        return ResponseEntity.ok(user) ;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getallUser() ;
    }

}
