package com.example.securityDemo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${secret.key}")
    private String secretKey;

//    private static final Long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 60L;
    private static final Long ACCESS_TOKEN_VALIDITY = 1000 * 10L;
    private static final Long REFRESH_TOKEN_VALIDITY = 1000 * 60 * 60 * 24 * 7L;
    private static final String ACCESS = "Access";
    private static final String REFRESH = "Refresh";

    private Key getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String username, boolean accessToken) {
        Long validity = accessToken ? ACCESS_TOKEN_VALIDITY : REFRESH_TOKEN_VALIDITY;
        String type = accessToken ? ACCESS : REFRESH;
        return Jwts.builder()
                .subject(username)
                .claim("type", type)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + validity))
                .signWith(getKey())
                .compact();
    }

    public String generateAccessToken(String username) {
        return generateToken(username, true);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, false);
    }

    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (SignatureException | ExpiredJwtException | MalformedJwtException e) {
            return false;
        }
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String getUsername(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    public String getTokenType(String token) {
        Claims claims = parseToken(token);
        return ObjectUtils.isEmpty(claims.get("type")) ? null : claims.get("type").toString();
    }

    public Date getExpiration(String token) {
        Claims claims = parseToken(token);
        return claims.getExpiration();
    }

    public String getAccessTokenType() {
        return ACCESS;
    }

    public String getRefreshTokenType() {
        return REFRESH;
    }
}
