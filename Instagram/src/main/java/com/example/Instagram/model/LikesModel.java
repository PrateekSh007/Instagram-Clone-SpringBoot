package com.example.Instagram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikesModel {

    private UUID id ;
    private UUID user1Id ;
    private UUID user2Id ;
    private UUID postId ;
    private LocalDateTime createdAt ;

}