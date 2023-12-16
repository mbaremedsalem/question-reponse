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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column()
    private String creationDate;
    @Column(nullable = false)
    private Boolean isValide;



    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    







}
