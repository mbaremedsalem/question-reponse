package com.example.questionreponse.web.ControllerApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.questionreponse.dto.AuthRequest;
import com.example.questionreponse.dto.RegisterModel;
import com.example.questionreponse.utils.Constants;

@RequestMapping(Constants.AUTH)
public interface PublicControllerApi {

        @PostMapping(Constants.REGISTER)
        public ResponseEntity<?> register(@RequestBody RegisterModel registerModel);

        @PostMapping(Constants.LOGIN)
        public ResponseEntity<?> login(@RequestBody AuthRequest authRequest);
}