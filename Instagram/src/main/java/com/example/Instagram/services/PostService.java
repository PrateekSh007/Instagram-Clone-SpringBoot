package com.example.Instagram.services;

import com.example.Instagram.entity.PostEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {

    PostEntity createPost(PostEntity post, UUID userId);

    Optional<PostEntity> getPostById(UUID id);

}
