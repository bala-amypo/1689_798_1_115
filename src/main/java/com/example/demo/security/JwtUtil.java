package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    private String secret;
    private long validity;

    public JwtUtil(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    // Required by Test 49
    public String generateToken(Long id, String email, String role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", id);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Required by Test 50 & 57
    public String extractEmail(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    // Required by Test 51
    public String extractRole(String token) {
        return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role");
    }

    // Required by Test 52
    public Long extractUserId(String token) {
        return ((Number) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userId")).longValue();
    }

    // Required by Test 53 & 58
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}