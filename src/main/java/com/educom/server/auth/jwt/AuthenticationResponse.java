package com.educom.server.auth.jwt;

import java.util.List;

public class AuthenticationResponse {
    private final String jwt;
    private String type = "Bearer";
    private String username;
    private String email;
    private List<String> roles;
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public AuthenticationResponse(String jwt, String username, List<String> roles) {
        this.jwt = jwt;


        this.username = username;

        this.roles = roles;
    }
}
