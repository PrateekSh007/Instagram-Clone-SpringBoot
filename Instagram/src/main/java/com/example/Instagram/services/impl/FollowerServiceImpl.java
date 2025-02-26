package com.example.Instagram.services.impl;

import com.example.Instagram.entity.FollowerEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.repository.FollowerRepository;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.FollowerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FollowerServiceImpl implements FollowerService{

    @Autowired
    private FollowerRepository followerRepository ;

    @Autowired
    private UserRepository userRepository ;


    @Override
    public FollowerEntity followUser(UUID followerId, UUID followingId) {
        Optional<UserEntity> follower = userRepository.findById(followerId);
        Optional<UserEntity> following = userRepository.findById(followingId);

        if (follower.isEmpty() || following.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        FollowerEntity followerEntity = new FollowerEntity();
        followerEntity.setFollower(follower.get());
        followerEntity.setFollowing(following.get());

        return followerRepository.save(followerEntity);
    }

}