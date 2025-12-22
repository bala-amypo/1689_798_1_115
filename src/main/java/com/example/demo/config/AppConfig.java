package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JwtUtil jwtUtil(@Value("${jwt.secret}") String secret, 
                           @Value("${jwt.validity}") long validity) {
        return new JwtUtil(secret, validity);
    }
}