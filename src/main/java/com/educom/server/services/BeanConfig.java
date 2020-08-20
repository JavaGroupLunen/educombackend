package com.educom.server.services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;

@Configuration
public class BeanConfig {
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//    @Bean
//    public SessionFactory getSessionFactory(){
//        if(entityManagerFactory.unwrap(SessionFactory.class)==null){
//            throw new NullPointerException("factory is not a Hibernate Factory");
//        }
//        return entityManagerFactory.unwrap(SessionFactory.class);
//    }
@Value( "${app.allow.origins}" )
private String allowOrigins;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        System.out.println("allow origin: "+allowOrigins);
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //.allowedOrigins("http://localhost")
                        .allowedOrigins(allowOrigins)
                        .allowedMethods("PUT", "DELETE","GET", "POST");
            }
        };
    }
}
