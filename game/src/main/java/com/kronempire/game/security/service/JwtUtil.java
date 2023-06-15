package com.kronempire.game.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    //Retourne le corp du token
    public Claims tokenBodyExtractor(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")));
        return Jwts.builder()
                .setClaims(tokenData)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    //Retourne vrai si le token n'a pas dépassé la date d'expiration
    private Boolean deprecatedToken(String token) {
        return tokenBodyExtractor(token)
                .getExpiration()
                .after(new Date());
    }

    //Retourne vrai si le nom de l'utilisateur tentant de se connecter correspond
    //au subject du corp du token et si la date d'expiration n'est pas passée.
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = tokenBodyExtractor(token).getSubject();
        return (username.equals(userDetails.getUsername()) && deprecatedToken(token));
    }
}
