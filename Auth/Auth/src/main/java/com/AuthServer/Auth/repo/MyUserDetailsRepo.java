package com.AuthServer.Auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AuthServer.Auth.model.MyUserDetails;

@Repository
public interface MyUserDetailsRepo extends JpaRepository<MyUserDetails, Integer> {
		Optional<MyUserDetails> findByEmail(String userName);
}
