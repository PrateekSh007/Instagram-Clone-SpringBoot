package com.example.Instagram.services;

import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.LoginModel;
import com.example.Instagram.model.ResponseModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserEntity createUser(UserEntity user);
    Optional<UserEntity> getUserById(UUID id);
    List<UserEntity> getallUser();
    ResponseModel loginUser(LoginModel loginModel);
}
