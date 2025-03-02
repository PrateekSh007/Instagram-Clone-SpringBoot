package com.example.Instagram.controller;

import com.example.Instagram.entity.PostEntity;
import com.example.Instagram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody Map<String, Object> request) {
        String caption = (String) request.get("caption");
        String imageUrl = (String) request.get("image_url");
        UUID userId = UUID.fromString((String) request.get("userId"));

        PostEntity post = new PostEntity();
        post.setCaption(caption);
        post.setImage_url(imageUrl);

        PostEntity createdPost = postService.createPost(post, userId);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostEntity>> getPostById(@PathVariable UUID id) {
        Optional<PostEntity> post = postService.getPostById(id) ;
        return ResponseEntity.ok(post) ;
    }



}