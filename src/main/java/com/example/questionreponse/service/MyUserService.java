package com.example.questionreponse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionreponse.dao.MyUserRepository;
import com.example.questionreponse.entity.MyUser;

@Service
public class MyUserService {
    
    @Autowired
    private MyUserRepository userRepository;

    public MyUser findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
}
