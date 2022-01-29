package com.elcorp.pocsecurity.jwt;

import com.elcorp.pocsecurity.dto.UserAuthenticationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class ApplicationUserAuthentication extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ApplicationJWTConfiguration applicationJWTConfiguration;
    private final SecretKey secretKey;

    public ApplicationUserAuthentication(
            AuthenticationManager authenticationManager,
            ApplicationJWTConfiguration applicationJWTConfiguration,
            SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.applicationJWTConfiguration = applicationJWTConfiguration;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserAuthenticationDTO authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UserAuthenticationDTO.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
            Authentication authenticated = authenticationManager.authenticate(authentication);
            return authenticated;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(
                        LocalDate.now().plusDays(applicationJWTConfiguration.getTokenExpirationAfterDays())
                ))
                .signWith(secretKey)
                .compact();

        response.addHeader(
                applicationJWTConfiguration.getAuthorizationHeader(),
                applicationJWTConfiguration.getTokenPrefix()+" "+token
        );
    }
}
