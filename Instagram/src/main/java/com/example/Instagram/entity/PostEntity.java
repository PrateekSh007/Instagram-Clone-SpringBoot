package com.example.Instagram.entity;


import com.example.Instagram.model.LikesModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String caption;

    @Column(nullable = false)
    private String image_url;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("post-likes")
    private Set<LikesEntity> likes;

    public List<LikesModel> getLikes() {
        return likes.stream().map(like -> {
            LikesModel model = new LikesModel();
            model.setId(like.getId());
            model.setUser1Id(like.getUser1().getId());
            model.setUser2Id(like.getUser2().getId());
            model.setPostId(like.getPost().getId());
            model.setCreatedAt(like.getCreatedAt());
            return model;
        }).collect(Collectors.toList());
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-posts")
    private UserEntity user;

}