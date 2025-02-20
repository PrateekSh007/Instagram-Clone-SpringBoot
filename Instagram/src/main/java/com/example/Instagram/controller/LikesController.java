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
//        Optional<LikesEntity> existinglikecheck = likesRepository.findByUser1_IdAndUser2_IdAndPost_Id(user1Id,user2Id,postId) ;
//
//        if(existinglikecheck.isPresent()){
//            likesRepository.delete(existinglikecheck.get());
//            return ResponseEntity.ok().build();
//        }
//        else {
//
//            LikesEntity likesEntity = likesService.likes(user1Id, user2Id, postId);
//            LikesModel likesModel = new LikesModel();
//            likesModel.setId(likesEntity.getId());
//            likesModel.setUser1Id(likesEntity.getUser1().getId());
//            likesModel.setUser2Id(likesEntity.getUser2().getId());
//            likesModel.setPostId(likesEntity.getPost().getId());
//            likesModel.setCreatedAt(likesEntity.getCreatedAt());
//
//            return ResponseEntity.ok(likesModel);
//        }

        Optional<LikesEntity> existingLike = likesRepository.findByUser1_IdAndUser2_IdAndPost_Id(user1Id, user2Id, postId);

        if (existingLike.isPresent()) {
           
            likesRepository.delete(existingLike.get());
            return ResponseEntity.noContent().build(); // Return no content response for deletion
        } else {

            LikesEntity likesEntity = likesService.likes(user1Id, user2Id, postId);


            LikesModel likesModel = new LikesModel();
            likesModel.setId(likesEntity.getId());
            likesModel.setUser1Id(likesEntity.getUser1().getId());
            likesModel.setUser2Id(likesEntity.getUser2().getId());
            likesModel.setPostId(likesEntity.getPost().getId());
            likesModel.setCreatedAt(likesEntity.getCreatedAt());

            return ResponseEntity.ok(likesModel); // Return the created like


        }

    }
}