package com.example.Instagram.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")

public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(nullable = false , unique = true , length = 50)
    private String username ;

    @Column(nullable = false , unique = true , length = 100)
    private String email ;

    @Column(nullable = false , unique = false , length = 50)
    private String password ;

    @Column(length = 100)
    private String bio ;

    @Column(nullable = false)
    private String profilepic ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<PostEntity> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StoryEntity> story ;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}