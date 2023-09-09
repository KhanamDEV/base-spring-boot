package com.tkg.MasterSystem.services.impl;

import com.tkg.MasterSystem.payload.requests.authentication.SendSignInCodeRequest;
import com.tkg.MasterSystem.repositories.UserRepositoryInterface;
import com.tkg.MasterSystem.services.AuthenticationServiceInterface;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Objects;


@Service
public class AuthenticationService implements AuthenticationServiceInterface {

    @Autowired
    Environment environment;

    @Value("${JWT_SECRET_KEY}")
    private String jwtSecret;

    private final UserRepositoryInterface userRepository;

    public Key getSecretKey(){
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Autowired
    public AuthenticationService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepository = userRepositoryInterface;
    }

    @Override
    public boolean sendSignUpCode(SendSignInCodeRequest sendSignInCodeRequest) {
        return userRepository.existsByEmail(sendSignInCodeRequest.getEmail());
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String generateToken( UserDetails userDetails) {
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 90))
                .signWith(getSecretKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        Claims claims = extractAllClaims(token);
        final String username = claims.getSubject();
        Date tokenExpiration = claims.getExpiration();
        return username.equals(userDetails.getUsername()) && tokenExpiration.before(new Date());
    }


}
