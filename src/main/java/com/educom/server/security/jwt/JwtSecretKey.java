package com.educom.server.security.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtSecretKey {
    private final JwtConfig jwt;

@Autowired
    public JwtSecretKey(JwtConfig jwt) {
        this.jwt = jwt;
    }


    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(jwt.getSecretKey().getBytes());
    }
}
