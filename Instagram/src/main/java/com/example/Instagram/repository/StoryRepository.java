package com.example.Instagram.repository;


import com.example.Instagram.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoryRepository  extends JpaRepository<StoryEntity,UUID> {

}
