package com.example.Instagram.services;

import com.example.Instagram.entity.LikesEntity;
import com.example.Instagram.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface LikesService {

    LikesEntity likes(UUID user1Id, UUID user2Id, UUID postId) ;

    Optional<UserEntity> getUserByLikeId(UUID likeid);


}

