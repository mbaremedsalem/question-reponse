package com.example.questionreponse.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String username;
    @Column(nullable = true)
    private String email;


    
    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Question> questions;
    @OneToMany(mappedBy = "user")
    private List<Answer> answers;



    
}
