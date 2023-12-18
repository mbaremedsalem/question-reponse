package com.example.questionreponse.requests;

import lombok.Data;

@Data
public class AnswerRequest {
    private String content;
    private Long userId;
}

