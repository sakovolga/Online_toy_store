//package com.example.online_toy_store.security;
//
//import com.example.online_toy_store.security.securityUtil.JwtUtil;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthFilter {
//
//    private final JwtUtil jwtUtil;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthFilter(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
//        this.jwtUtil = jwtUtil;
//        this.authenticationManager = authenticationManager;
//    }
//
//    public String singIn(String username, String password) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        return jwtUtil.generateJwtUtils(authentication);
//    }
//}