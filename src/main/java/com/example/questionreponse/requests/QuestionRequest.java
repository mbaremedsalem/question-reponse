package com.example.questionreponse.requests;
import java.util.List;
import com.example.questionreponse.entity.Answer;
import lombok.Data;


@Data
public class QuestionRequest {
    private String content;
    private Boolean isValide;
    private Long userId;
    private List<Answer> answers;
}
