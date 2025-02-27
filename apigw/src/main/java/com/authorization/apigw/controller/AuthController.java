package com.authorization.apigw.controller;

import com.authorization.apigw.model.AuthRequest;
import com.authorization.apigw.service.JwtTokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/")
public class AuthController {
    @Inject
    private JwtTokenService jwtTokenService;

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest request)
    {
		return null;
    }
}
