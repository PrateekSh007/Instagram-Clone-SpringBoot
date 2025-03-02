package com.example.Instagram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoryModel {

    private UUID id;
    private String username;
    private String imageVideo_url;
    private LocalDateTime createdAt;
    private UUID userId;
}