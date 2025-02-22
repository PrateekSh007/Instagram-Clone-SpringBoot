package com.example.Instagram.services.impl;

import com.example.Instagram.entity.LikesEntity;
import com.example.Instagram.entity.PostEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.repository.LikesRepository;
import com.example.Instagram.repository.PostRepository;
import com.example.Instagram.repository.UserRepository;
import com.example.Instagram.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesRepository likesRepository ;

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private PostRepository postRepository ;

    @Override
    public LikesEntity likes(UUID user1Id,UUID user2Id , UUID postId) {
        Optional<UserEntity> user1 = userRepository.findById(user1Id) ;
        Optional<UserEntity> user2 = userRepository.findById(user2Id) ;
        Optional<PostEntity> post = postRepository.findById(postId) ;

        LikesEntity likesEntity = new LikesEntity() ;
        likesEntity.setPost(post.get());
        likesEntity.setUser1(user1.get());
        likesEntity.setUser2(user2.get());

        return likesRepository.save(likesEntity) ;
    }
    @Override
    public Optional<UserEntity> getUserByLikeId(UUID likeid) {
        Optional<LikesEntity> like = likesRepository.findById(likeid);
        return like.map(LikesEntity::getUser2);
    }


}