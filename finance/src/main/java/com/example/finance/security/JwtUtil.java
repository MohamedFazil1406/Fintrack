package com.example.finance.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;



@Component
public class JwtUtil {

    @Value("${JWT_SECRET_KEY}")
    private String secretKey;



    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 🔹 Generate Token
    public String generateToken(String email,String role) {
        System.out.println("GENERATING TOKEN WITH KEY: " + secretKey);
        return Jwts.builder()
                .setSubject(email)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    // 🔹 Extract Email
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 🔹 Validate Token
    public boolean validateToken(String token) {
        System.out.println("VALIDATING TOKEN WITH KEY: " + secretKey);
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role",String.class);
    }
}


