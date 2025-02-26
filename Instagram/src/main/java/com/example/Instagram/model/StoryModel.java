package com.example.Instagram.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoryModel {

    private UUID id ;
    private String username ;
    private LocalDateTime createdAt  ;

}
