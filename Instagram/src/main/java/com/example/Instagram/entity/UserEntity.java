package com.example.Instagram.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


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
    private Set<PostEntity> posts ;




}
