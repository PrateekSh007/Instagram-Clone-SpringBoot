package com.example.Instagram.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "followers")
public class FollowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @ManyToOne
    @JoinColumn(name = "follower_id",nullable = false)
    private UserEntity follower ;

    @ManyToOne
    @JoinColumn(name = "following_id",nullable = false)
    private UserEntity following ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}