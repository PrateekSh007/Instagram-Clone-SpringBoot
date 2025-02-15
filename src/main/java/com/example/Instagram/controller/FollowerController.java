package com.example.Instagram.controller;


import com.example.Instagram.entity.FollowerEntity;
import com.example.Instagram.services.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/follow")
public class FollowerController {

    @Autowired
    private FollowerService followerService ;

    @PostMapping
    public ResponseEntity<FollowerEntity> follower(@RequestParam UUID followerId , @RequestParam UUID followingId){
        FollowerEntity followerEntity = followerService.followUser(followerId , followingId) ;
        return ResponseEntity.ok(followerEntity) ;
    }
}
