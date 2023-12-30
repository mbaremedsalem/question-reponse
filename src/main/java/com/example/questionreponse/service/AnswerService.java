package com.example.questionreponse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionreponse.dao.AnswerRepository;
import com.example.questionreponse.entity.Answer;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository repository;

    public List<Answer> findAll(){
        return repository.findAll();
    }

    public Answer create(Answer answer){
        return repository.save(answer);
    }

    public boolean delete(Long id) {
        try {
            Optional<Answer> serverOptional = repository.findById(id);
    
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
    public Answer update(Long id, Answer updatedAnswer) {
        Optional<Answer> existingAnswerOptional = repository.findById(id);

        if (existingAnswerOptional.isPresent()) {
            Answer existingAnswer = existingAnswerOptional.get();
            // Update fields of existingCompany with values from updatedCompany
            existingAnswer.setContent(updatedAnswer.getContent()); 
            existingAnswer.setUser(updatedAnswer.getUser());    
            return repository.save(existingAnswer);
        } else {
            return null; // Or throw an exception if you prefer
        }
    }
}
