package com.elcorp.pocsecurity.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JWTSecretKeyCrypt {

    private final ApplicationJWTConfiguration applicationJWTConfiguration;

    @Autowired
    public JWTSecretKeyCrypt(ApplicationJWTConfiguration applicationJWTConfiguration) {
        this.applicationJWTConfiguration = applicationJWTConfiguration;
    }

    @Bean
    public SecretKey secretKey(){
        return Keys.hmacShaKeyFor(applicationJWTConfiguration.getSecretKey().getBytes());
    }
}
