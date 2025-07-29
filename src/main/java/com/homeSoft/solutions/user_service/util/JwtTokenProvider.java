package com.homeSoft.solutions.user_service.util;

import com.homeSoft.solutions.user_service.model.DeviceMetadata;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    private final String secretKey = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D";
    private final long validityInMilliseconds = 3600000;

    public String generateToken(String username, DeviceMetadata deviceMetadata) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("device", deviceMetadata);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
