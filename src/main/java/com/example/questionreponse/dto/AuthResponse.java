package com.example.questionreponse.dto;

import com.example.questionreponse.entity.MyUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final MyUser user;
}