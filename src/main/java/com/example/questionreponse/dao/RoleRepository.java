package com.example.questionreponse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionreponse.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
