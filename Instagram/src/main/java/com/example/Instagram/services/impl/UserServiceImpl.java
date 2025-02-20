package com.example.Instagram.services.impl;

import com.example.Instagram.Utility.JwtUtil;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.LoginModel;
import com.example.Instagram.model.ResponseModel;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public ResponseModel loginUser(LoginModel loginmodel){
        Optional<UserEntity> userOpt = userRepository.findByEmail(loginmodel.getEmail()) ;
        if (userOpt.isEmpty() || !(Objects.equals(userOpt.get().getPassword(), loginmodel.getPassword()))) {
            try {
                throw new Exception("Invalid email or password");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        ResponseModel responseModel = new ResponseModel() ;
        responseModel.setToken(JwtUtil.generateToken(userOpt.get().getEmail(), userOpt.get().getId()));
        return responseModel ;

    }


}