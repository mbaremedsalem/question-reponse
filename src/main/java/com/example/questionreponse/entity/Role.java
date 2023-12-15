package com.example.questionreponse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class  Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String name;

}


// relation avec user many toone 