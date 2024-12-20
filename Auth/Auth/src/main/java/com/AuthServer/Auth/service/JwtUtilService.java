package com.AuthServer.Auth.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtilService {
	
	private static final String secertKey="F15C7017C68E20BE7965270447C07F0DA83083FC1834B6EDB26DC79B24CDFC7368D9435176CCC278DBD1F6C18F3246520DC7DAD85F227040E9CF12AD030D2361";
	
	
	public void validateToken(final String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}
	
	public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }
	
	private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
	
	private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secertKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
