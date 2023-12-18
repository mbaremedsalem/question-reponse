package com.example.questionreponse.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false,columnDefinition = "boolean default true")
    private Boolean isValide;

    @ManyToOne
    private MyUser user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
    
}
