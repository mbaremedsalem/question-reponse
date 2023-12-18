package com.example.questionreponse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long>{
    
}
