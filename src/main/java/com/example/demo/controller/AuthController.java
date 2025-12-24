package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest req) {
        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        User saved = userService.registerUser(u);
        
        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new JwtResponse(token, saved.getEmail(), saved.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        User u = userService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new JwtResponse(token, u.getEmail(), u.getRole()));
    }
}