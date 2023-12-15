package com.example.questionreponse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.questionreponse.entity.Role;
import com.example.questionreponse.services.RoleService;

@RestController
@RequestMapping("/api/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("create-role")
    public ResponseEntity<Role> create(@RequestBody Role role ){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
    }
}