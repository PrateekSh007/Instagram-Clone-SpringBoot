package com.example.Instagram.repository;

import com.example.Instagram.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface LikesRepository extends JpaRepository<LikesEntity, UUID> {
}
