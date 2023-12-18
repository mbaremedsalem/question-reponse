package com.example.questionreponse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionreponse.entity.MyUser;
import com.example.questionreponse.entity.Question;
import com.example.questionreponse.requests.QuestionRequest;
import com.example.questionreponse.service.MyUserService;
import com.example.questionreponse.service.QuestionSrevice;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionSrevice service;
    @Autowired
    private MyUserService userService;
    
    @PostMapping("/create-question")
    public ResponseEntity<Question> create(@RequestBody QuestionRequest questionRequest){
    // Fetch the associated user
    MyUser user = userService.findById(questionRequest.getUserId());

    // Make sure the user exists
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    // Create the Answer entity
    Question question = new Question();
    question.setContent(questionRequest.getContent());
    question.setUser(user);

    // Create the answer
    Question createdAnswer = service.create(question);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }
}
