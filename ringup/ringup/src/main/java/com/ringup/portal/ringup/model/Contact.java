package com.ringup.portal.ringup.model;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId;
	private String contactName;
	private String contactNumber;
	private String email;
	private String contactType;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(nullable = false, updatable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
