package com.example.questionreponse.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long>{
    Optional<MyUser> findByUsername(String username);
    List<MyUser> findByUsernameContains(String username);
    Optional<MyUser> findByEmail(String email);
}

