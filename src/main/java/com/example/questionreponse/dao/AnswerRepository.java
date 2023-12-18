package com.example.questionreponse.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.Answer;
@Repository

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
