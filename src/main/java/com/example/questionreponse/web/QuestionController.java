package com.example.questionreponse.web;

import java.util.List;
import java.util.Map;

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


import com.example.questionreponse.entity.MyUser;
import com.example.questionreponse.entity.Question;
import com.example.questionreponse.requests.QuestionRequest;

import com.example.questionreponse.service.QuestionSrevice;
import com.example.questionreponse.service.UserServices;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionSrevice service;
    @Autowired
    private UserServices userService;
    
    @PostMapping("/create-question")
    public ResponseEntity<Question> create(@RequestBody QuestionRequest questionRequest){
    // Fetch the associated user
    MyUser user = userService.findById(questionRequest.getUserId());

    // Make sure the user exists
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    // Create the question entity
    Question question = new Question();
    question.setContent(questionRequest.getContent());
    question.setUser(user);

    // Create the answer
    Question createdAnswer = service.create(question);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping("/all-valid-question")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    
    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        try {
            boolean deletionStatus = service.delete(id);
    
            if (deletionStatus) {
                return ResponseEntity.status(HttpStatus.OK).body("question deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("question not found");
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PutMapping("/update-question/{questionId}")
    public ResponseEntity<Question> updateCompany(
            @PathVariable Long questionId,
            @RequestBody Question updatedQuestionId) {

        Question updated = service.update(questionId, updatedQuestionId);

        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

//pour valider une question  
    @PutMapping("/mark-as-valid/{id}")
    public ResponseEntity<String> markQuestionAsValid(@PathVariable Long id, @RequestBody Map<String, Boolean> request) {
        Boolean isValide = request.get("isValide");
        if (isValide == null) {
            return ResponseEntity.badRequest().body("Please provide the 'isValide' value in the request body.");
        }
        return service.markQuestionAsValid(id, isValide);
    }
}
