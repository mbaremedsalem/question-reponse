package com.example.questionreponse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
