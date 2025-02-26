package com.example.Instagram.services.impl;

import com.example.Instagram.repository.StoryRepository;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository ;

    @Autowired
    private UserRepository userRepository ;


}
