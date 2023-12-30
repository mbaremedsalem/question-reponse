package com.example.questionreponse.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionreponse.entity.Answer;
import com.example.questionreponse.entity.MyUser;
import com.example.questionreponse.requests.AnswerRequest;
import com.example.questionreponse.service.AnswerService;
import com.example.questionreponse.service.UserServices;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private AnswerService service;
    @Autowired
    private UserServices userService;

    @PostMapping("/create-answer")
    public ResponseEntity<Answer> create(@RequestBody AnswerRequest answerRequest){
    // Fetch the associated user
    MyUser user = userService.findById(answerRequest.getUserId());

    // Make sure the user exists
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    // Create the Answer entity
    Answer answer = new Answer();
    answer.setContent(answerRequest.getContent());
    answer.setUser(user);

    // Create the answer
    Answer createdAnswer = service.create(answer);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping("/all-answer")
    public ResponseEntity<List<Answer>> getAllAnswer(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    
    @DeleteMapping("/delete-answer/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        try {
            boolean deletionStatus = service.delete(id);
    
            if (deletionStatus) {
                return ResponseEntity.status(HttpStatus.OK).body("Answer deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer not found");
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PutMapping("/update-anwser/{AnswerId}")
    public ResponseEntity<Answer> updateAnswer(
            @PathVariable Long answerId,
            @RequestBody Answer updatedAnswer) {

        Answer updated = service.update(answerId, updatedAnswer);

        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
