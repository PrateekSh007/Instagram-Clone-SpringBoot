package com.example.Instagram.repository;

import com.example.Instagram.entity.FollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FollowerRepository extends JpaRepository<FollowerEntity, UUID> {
}
