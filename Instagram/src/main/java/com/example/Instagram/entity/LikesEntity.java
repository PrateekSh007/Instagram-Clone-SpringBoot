package com.example.Instagram.entity;

import com.example.Instagram.model.PostModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "likes")
public class LikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private PostEntity post ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}
