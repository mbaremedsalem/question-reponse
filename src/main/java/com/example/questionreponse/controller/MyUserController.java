package com.example.questionreponse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionreponse.entity.MyUser;
import com.example.questionreponse.services.MyUserService;

// UserController.java
@RestController
@RequestMapping("/api/")
public class MyUserController {
    @Autowired
    private MyUserService userService;

    @PostMapping("create-user")
    public ResponseEntity<MyUser> create(@RequestBody MyUser myuser ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(myuser));
    }
}
