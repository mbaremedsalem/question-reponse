package com.example.questionreponse.service;


import java.util.List;
import org.springframework.http.ResponseEntity;
import com.example.questionreponse.entity.MyUser;

public interface UserServices {

    public ResponseEntity<?> addUser(MyUser userInfo);

    public MyUser fidUserByUsername(String username);

    public void DeleteUser(long id);

    public boolean findUserById(long id);

    public List<MyUser> getUsers();

    public MyUser findById(long long1);
}