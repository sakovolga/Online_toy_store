package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
