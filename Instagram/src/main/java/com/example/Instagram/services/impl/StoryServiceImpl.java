package com.example.Instagram.services.impl;

import com.example.Instagram.entity.StoryEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.StoryModel;
import com.example.Instagram.repository.StoryRepository;
import com.example.Instagram.services.StoryService;
import com.example.Instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;

    @Override
    public StoryEntity postStory(StoryModel storyModel) {
        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setUsername(storyModel.getUsername());
        storyEntity.setImageVideo_url(storyModel.getImageVideo_url());
        storyEntity.setCreatedAt(storyModel.getCreatedAt());

        UserEntity user = userService.getUserById(storyModel.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + storyModel.getUserId());
        }
        storyEntity.setUser(user);

        return storyRepository.save(storyEntity);
    }

//    @Override
//    public Optional<UserEntity>  getUserbyStoryId(UUID storyId) {
//        Optional<StoryEntity> story = storyRepository.findById(storyId) ;
////        return like.map(LikesEntity::getUser2);
//        return story.map(UserEntity:getUser()) ;
//    }
//
    @Override
    public Optional<UserEntity> getUserByStoryId(UUID storyId) {
        Optional<StoryEntity> story = storyRepository.findById(storyId);
        return story.map(StoryEntity::getUser);
    }
}