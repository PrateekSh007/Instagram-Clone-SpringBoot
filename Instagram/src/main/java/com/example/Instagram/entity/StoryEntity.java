package com.example.Instagram.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "story")
public class StoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(nullable = false)
    private String username ;

    @Column(nullable = false)
    private String imageVideo_url ;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-story")
    private UserEntity user;


}
