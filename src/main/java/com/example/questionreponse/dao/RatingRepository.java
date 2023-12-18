package com.example.questionreponse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionreponse.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    
}
