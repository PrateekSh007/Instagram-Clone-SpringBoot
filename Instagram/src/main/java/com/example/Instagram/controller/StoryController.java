package com.example.Instagram.controller;

import com.example.Instagram.entity.StoryEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.StoryModel;
import com.example.Instagram.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @PostMapping
    public ResponseEntity<StoryEntity> postStory(@RequestBody StoryModel storyModel) {
        StoryEntity storyEntity = storyService.postStory(storyModel);
        return ResponseEntity.ok(storyEntity);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserByStoryId(@PathVariable UUID id) {
        Optional<UserEntity> userEntity = storyService.getUserByStoryId(id) ;
        return ResponseEntity.ok(userEntity) ;
    }
}