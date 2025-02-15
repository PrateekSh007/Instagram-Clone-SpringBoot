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

public class UserModel {

    private UUID id ;
    private String username ;
    private String email ;
    private String password ;
    private String bio ;
    private String profilepic ;
    private LocalDateTime createdAt  ;


}
