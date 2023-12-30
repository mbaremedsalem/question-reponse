package com.example.questionreponse.response;

public class AuthenticationResponse {

    private final String jwtToken;

    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
    
    // Getter, Setter, other methods if necessary...
}
