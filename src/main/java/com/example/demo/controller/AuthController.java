package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole; // Import the Enum!
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Register and Login endpoints")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public String register(@RequestBody RegisterRequest request) {
        // Fix: Use getEmail()
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already taken!");
        }
        User user = new User();
        // Fix: Use getFullName(), getEmail(), getPassword()
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        // Fix: Set Enum instead of String
        user.setRole(UserRole.MONITOR); 
        
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    @Operation(summary = "Login and get JWT Token")
    public JwtResponse login(@RequestBody LoginRequest request) {
        // Fix: Use getEmail()
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fix: Use getPassword()
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        
        // Fix: Convert Enum to String for response
        return new JwtResponse(token, user.getEmail(), user.getRole().toString());
    }
}