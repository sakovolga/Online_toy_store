package com.example.online_toy_store.security.securityUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("qwerty")
    private String jwtSecret;

    @Value("86400000")
    private int jwtLiveTime;


    public String generateToken(String subject, Map<String, Object> claims, int jwtLiveTime) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date()).expiration(new Date(new Date().getTime() + jwtLiveTime))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String generateJwtUtils(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return generateToken(userDetails.getUsername(), Collections.emptyMap(), jwtLiveTime);
    }


    public boolean isValidJwt(String jwt) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).build().parse(jwt);
            return true;
        } catch (Exception e) {
            System.out.println("WRITE EXCEPTION");
        }
        return false;
    }

    public Claims getBody(String token) {
        return (Claims) Jwts.parser().setSigningKey(jwtSecret).build().parse(token);
    }
}