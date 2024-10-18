package com.thullyooo.owner_micro_service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JWTService {

    @Autowired
    private JwtEncoder jwtEncoder;

    public String generateToken(Authentication authentication){

        var claims = JwtClaimsSet.builder()
                .issuer("jwt-service")
                .expiresAt(Instant.now().plusSeconds(3000L))
                .issuedAt(Instant.now())
                .subject(authentication.getName())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
