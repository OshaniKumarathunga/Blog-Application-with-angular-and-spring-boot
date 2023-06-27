package com.angular.blogbackend.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtProvider {

    private Key key;

    @PostConstruct
    public void init(){
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();

    }

    public boolean validateToken(String jwt){
        Jwts.parserBuilder().setSigningKey(key).build().parse(jwt);
        return true;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
