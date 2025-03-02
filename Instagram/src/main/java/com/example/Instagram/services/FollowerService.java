package com.example.Instagram.services;

import com.example.Instagram.entity.FollowerEntity;

import java.util.List;
import java.util.UUID;

public interface FollowerService {

    FollowerEntity followUser(UUID followerId, UUID followingId);
}
