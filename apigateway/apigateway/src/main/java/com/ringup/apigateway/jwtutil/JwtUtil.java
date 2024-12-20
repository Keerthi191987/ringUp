package com.ringup.apigateway.jwtutil;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	 public static final String secertKey="F15C7017C68E20BE7965270447C07F0DA83083FC1834B6EDB26DC79B24CDFC7368D9435176CCC278DBD1F6C18F3246520DC7DAD85F227040E9CF12AD030D2361";


	    public void validateToken(final String token) {
	        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	        
	    }
	    private Key getSignKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(secertKey);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }

}
