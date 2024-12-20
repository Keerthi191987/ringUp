package com.AuthServer.Auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AuthServer.Auth.model.CustomUserDetails;
import com.AuthServer.Auth.model.MyUserDetails;
import com.AuthServer.Auth.repo.MyUserDetailsRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	 @Autowired
	 private MyUserDetailsRepo myUserDetailsRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Optional<MyUserDetails> credential = myUserDetailsRepo.findByEmail(email);
	     return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with mail id :" + email));
	}

}
