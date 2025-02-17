package com.example.Instagram.controller;


import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.Instagram.entity.LikesEntity;
import com.example.Instagram.entity.UserEntity;
import com.example.Instagram.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/post/likes")
public class LikesController {

    @Autowired
    private LikesService likesService ;

    @PostMapping
    public ResponseEntity<Optional<LikesEntity>> likes(@RequestParam UUID userId , @RequestParam UUID postId) {
        LikesEntity likesEntity = likesService.likes(userId,postId) ;
        return ResponseEntity.ok(Optional.ofNullable(likesEntity)) ;
    }


}
