package com.AuthServer.Auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AuthServer.Auth.model.MyUserDetails;
import com.AuthServer.Auth.service.MyAuthUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private MyAuthUserDetailsService myAuthUserDetailsService;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public MyUserDetails addUser(@RequestBody MyUserDetails userDetails) {
		return myAuthUserDetailsService.saveMyUserDetails(userDetails);
	}
	
	@PostMapping("/getToken")
	public String getToken(@RequestBody MyUserDetails userDetails) {
		 Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getEmail(), userDetails.getPassword()));
	        if (authenticate.isAuthenticated()) {
	            return myAuthUserDetailsService.generateToken(userDetails.getEmail());
	        } else {
	            throw new RuntimeException("invalid access");
	        }		
		
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		 myAuthUserDetailsService.isValidToke(token);
		 return "Token is Valid";
		 
		
	}
	
	

}
