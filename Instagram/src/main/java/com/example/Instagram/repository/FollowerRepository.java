package com.example.Instagram.repository;

import com.example.Instagram.entity.FollowerEntity;
import com.example.Instagram.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowerRepository extends JpaRepository<FollowerEntity, UUID> {
    List<FollowerEntity> findByFollower(UserEntity follower);
    List<FollowerEntity> findByFollowing(UserEntity following);
}
