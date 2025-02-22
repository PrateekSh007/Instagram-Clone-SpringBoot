package com.example.Instagram.controller;


import com.example.Instagram.entity.LikesEntity;
import com.example.Instagram.model.LikesModel;
import com.example.Instagram.repository.LikesRepository;
import com.example.Instagram.services.LikesService;
import com.example.Instagram.services.impl.LikesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/post/likes")
public class LikesController {

    @Autowired
    private LikesService likesService ;

    @Autowired
    private LikesRepository likesRepository ;

    @PostMapping
    public ResponseEntity<LikesModel> likes(@RequestParam UUID user1Id, @RequestParam UUID user2Id, @RequestParam UUID postId) {

            LikesEntity likesEntity = likesService.likes(user1Id, user2Id, postId);
            LikesModel likesModel = new LikesModel();
            likesModel.setId(likesEntity.getId());
            likesModel.setUser1Id(likesEntity.getUser1().getId());
            likesModel.setUser2Id(likesEntity.getUser2().getId());
            likesModel.setPostId(likesEntity.getPost().getId());
            likesModel.setCreatedAt(likesEntity.getCreatedAt());
            return ResponseEntity.ok(likesModel);
    }
}