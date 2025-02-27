package com.authorization.apigw.model;

import lombok.*;
@Data
public class AuthRequest {
    private String username;
    private String password;
}
