package com.example.questionreponse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionreponse.dao.RoleRepository;
import com.example.questionreponse.entity.Role;
@Service 
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role){
        return roleRepository.save(role);
    }
}
