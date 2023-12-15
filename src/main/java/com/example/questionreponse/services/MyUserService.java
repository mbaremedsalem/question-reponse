package com.example.questionreponse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionreponse.dao.MyUserRepository;
import com.example.questionreponse.entity.MyUser;

@Service 
public class MyUserService {
    @Autowired
    private MyUserRepository mysuerrepository;

    public MyUser create(MyUser myuser){
        return mysuerrepository.save(myuser);
    }
}