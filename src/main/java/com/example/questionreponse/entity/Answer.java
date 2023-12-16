package com.example.questionreponse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String content;
    @Column()
    private String note;
    @Column()
    private String description;
    @Column()
    private String date;

    @ManyToOne
    private User user;
   
    @ManyToOne
    private Question question;






    
}
