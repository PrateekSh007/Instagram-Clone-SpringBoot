package com.example.Instagram.entity;

import com.example.Instagram.model.PostModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @ManyToOne
    @JoinColumn(name = "user1_id" , nullable = false)
    @JsonBackReference
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name = "user2_id" ,nullable = false)
    @JsonBackReference
    private UserEntity user2 ;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private PostEntity post;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}