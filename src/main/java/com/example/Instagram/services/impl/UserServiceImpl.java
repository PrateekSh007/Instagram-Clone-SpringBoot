package com.example.Instagram.services.impl;

import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository ;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user) ;
    }

    @Override
    public Optional<UserEntity> getUserById(UUID id ){
        return userRepository.findById(id) ;
    }

    @Override
    public List<UserEntity> getallUser() {
        return userRepository.findAll() ;
    }

}
