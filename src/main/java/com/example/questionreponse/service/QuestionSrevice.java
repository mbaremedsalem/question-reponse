package com.example.questionreponse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Question create(Question server){
        return repository.save(server);
    }

    public boolean delete(Long id) {
        try {
            Optional<Question> serverOptional = repository.findById(id);
    
            if (serverOptional.isPresent()) {
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
            existingQuestion.setCreationDate(updatedQuestion.getCreationDate());
            existingQuestion.setIsValide(updatedQuestion.getIsValide());
           
          
            return repository.save(existingQuestion);
        } else {
            return null; // Or throw an exception if you prefer
        }
    }
}
