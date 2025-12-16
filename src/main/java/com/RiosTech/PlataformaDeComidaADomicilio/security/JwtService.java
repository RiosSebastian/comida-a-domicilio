package com.RiosTech.PlataformaDeComidaADomicilio.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static jdk.jfr.internal.EventWriterKey.getKey;

@Service
public class JwtService {

    private static final String secret_key ="clave_secreta";


    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();

    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return  username.equals(userDetails.getUsername() && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    private Key getKey(){
        Byte[ ] KeyBytes = Decoders.BASE64.decode(Base64.getEncoder().encodeToString(Secret_key.getBytes()));
        return Keys.hmacShaKeyFor(KeyBytes);
    }

}
