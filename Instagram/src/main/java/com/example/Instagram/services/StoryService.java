package com.example.Instagram.services;

import com.example.Instagram.entity.StoryEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.model.StoryModel;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface StoryService {

    StoryEntity postStory(StoryModel storyModel) ;

    Optional<UserEntity> getUserByStoryId(UUID storyId) ;
}
