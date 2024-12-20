package com.AuthServer.Auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AuthServer.Auth.model.MyUserDetails;
import com.AuthServer.Auth.repo.MyUserDetailsRepo;

@Service
public class MyAuthUserDetailsService {
	
	@Autowired
	private MyUserDetailsRepo myUserDetailsRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtilService jwtUtilService;
	
	public MyUserDetails saveMyUserDetails(MyUserDetails myUserDetails) {
		myUserDetails.setPassword(passwordEncoder.encode(myUserDetails.getPassword()));
		return myUserDetailsRepo.save(myUserDetails);
	}
	
	public String generateToken(String userName) {
		return jwtUtilService.generateToken(userName);
		
	}
	
	public void isValidToke(String token) {
		jwtUtilService.validateToken(token);
	}
	
	

}
