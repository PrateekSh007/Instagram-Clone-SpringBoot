package com.example.Instagram.services.impl;

import com.example.Instagram.entity.PostEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.repository.PostRepository;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public PostEntity createPost(PostEntity post, UUID userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        post.setUser(user.get());
        return postRepository.save(post);
    }

    @Override
    public Optional<PostEntity> getPostById(UUID id) {
        return postRepository.findById(id) ;
    }

}