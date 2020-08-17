package com.educom.server;


import com.educom.server.auth.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EducomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducomApplication.class, args);
    }




}
