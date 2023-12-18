package com.example.questionreponse.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private MyUser user;

    @ManyToOne
    private Question question;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }






    
}
