package com.AuthServer.Auth.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_info")
public class MyUserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String username;
	private String password;
	private String email;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false, updatable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
