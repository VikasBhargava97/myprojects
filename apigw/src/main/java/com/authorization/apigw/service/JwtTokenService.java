package com.authorization.apigw.service;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {
    private final String secretKey = "secretKey";

    public String tokenGenerator(String username)
    {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
