package com.example.Instagram.repository;

import com.example.Instagram.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface LikesRepository extends JpaRepository<LikesEntity, UUID> {
    Optional<LikesEntity> findByUser1_IdAndUser2_IdAndPost_Id(UUID user1Id, UUID user2Id, UUID postId);
}