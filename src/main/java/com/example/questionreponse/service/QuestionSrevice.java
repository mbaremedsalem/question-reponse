package com.example.questionreponse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import com.example.questionreponse.dao.QuestionRepository;

import com.example.questionreponse.entity.Question;
@Service
public class QuestionSrevice {
    @Autowired
    private QuestionRepository repository;

    public List<Question> findAll(){
        return repository.findAll();
    }

    public Question create(Question question){
        return repository.save(question);
    }

    public boolean delete(Long id) {
        try {
            Optional<Question> questionOptional = repository.findById(id);
    
            if (questionOptional.isPresent()) {
                repository.deleteById(id);
                return true;
            } else {
                return false; // Company not found
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return false;
        }
    }
    public Question update(Long id, Question updatedQuestion) {
        Optional<Question> existingQuestionOptional = repository.findById(id);

        if (existingQuestionOptional.isPresent()) {
            Question existingQuestion = existingQuestionOptional.get();
            // Update fields of existingCompany with values from updatedCompany
            existingQuestion.setContent(updatedQuestion.getContent());
            return repository.save(existingQuestion);
        } else {
            return null; // Or throw an exception if you prefer
        }
    }
    // pour valider une question 
    public ResponseEntity<String> markQuestionAsValid(Long questionId, Boolean isValide) {
        Optional<Question> optionalQuestion = repository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            // Question question = optionalQuestion.get();
            // if (!question.getIsValide()) {
            //     question.setIsValide(isValide);
            //     repository.save(question);
            //     return ResponseEntity.ok("Question with ID " + questionId + " has been marked as valid.");
            // } else {
            //     return ResponseEntity.badRequest().body("Question with ID " + questionId + " is already valid.");
            // }
            return ResponseEntity.badRequest().body("Question with ID " + questionId + " is already valid.");

        }
        return ((BodyBuilder) ResponseEntity.notFound()).body("Question not found with ID: " + questionId);
    }


}
