package com.example.Instagram.services;

import com.example.Instagram.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserEntity createUser(UserEntity user);
    Optional<UserEntity> getUserById(UUID id);
    List<UserEntity> getallUser();
}
