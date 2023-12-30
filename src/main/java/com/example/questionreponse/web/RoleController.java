package com.example.questionreponse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionreponse.entity.Role;
import com.example.questionreponse.service.RoleServices;

import com.example.questionreponse.web.ControllerApi.RoleCotrollerApi;

@RestController
@CrossOrigin("*")
public class RoleController implements RoleCotrollerApi{
    @Autowired
    private RoleServices service;


    @Override
    public ResponseEntity<?> create(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRole(role));
    }

    
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        try {
            boolean deletionStatus = service.getRoleById(id) != null;
    
            if (deletionStatus) {
                return ResponseEntity.status(HttpStatus.OK).body("Role deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

}
