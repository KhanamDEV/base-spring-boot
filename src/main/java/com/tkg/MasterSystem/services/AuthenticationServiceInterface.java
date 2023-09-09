package com.tkg.MasterSystem.services;

import com.tkg.MasterSystem.payload.requests.authentication.SendSignInCodeRequest;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface AuthenticationServiceInterface {
    public boolean sendSignUpCode(SendSignInCodeRequest sendSignInCodeRequest);

    public Claims extractAllClaims(String token);

    public String generateToken(UserDetails userDetails);

    public boolean isTokenValid(String token, UserDetails userDetails);

}
