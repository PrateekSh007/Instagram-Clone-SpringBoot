package com.example.Instagram.controller;

import com.example.Instagram.entity.LikesEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.LoginModel;
import com.example.Instagram.model.ResponseModel;
import com.example.Instagram.model.UserModel;
import com.example.Instagram.services.LikesService;
import com.example.Instagram.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private LikesService likesService ;

    @PostMapping
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserModel user) {
            UserEntity createdUser = UserEntity.builder()
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .bio(user.getBio())
                    .profilepic(user.getProfilepic())
                    .build() ;

            UserEntity Usercreated = userService.createUser(createdUser) ;
            return ResponseEntity.ok(createdUser) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable UUID id) {
        Optional<UserEntity> user  = Optional.ofNullable(userService.getUserById(id));
        return ResponseEntity.ok(user) ;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getallUser() ;
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserByLikeId(@PathVariable UUID id) {
        Optional<UserEntity> user = likesService.getUserByLikeId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel, HttpServletResponse response) {
        try {
            ResponseModel responseModel = userService.loginUser(loginModel);

            Cookie cookie = new Cookie("token", responseModel.getToken());
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(6 * 60 * 60);

            response.addCookie(cookie);

            responseModel.setToken(null);

            return ResponseEntity.ok(responseModel);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}