package com.ringup.portal.ringup;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

public class JwtTokenMakerTest {

	@Test
	public void generateSecretKey() {
		SecretKey key=  Jwts.SIG.HS512.key().build();
		String keyEncode=DatatypeConverter.printHexBinary(key.getEncoded());
		System.out.println("key \n"+ keyEncode);
	}

}
