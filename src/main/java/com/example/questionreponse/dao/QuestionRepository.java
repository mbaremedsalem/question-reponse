package com.example.questionreponse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}
