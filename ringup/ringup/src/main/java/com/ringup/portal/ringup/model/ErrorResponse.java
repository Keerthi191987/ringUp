package com.ringup.portal.ringup.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class ErrorResponse {

	private int status;
    private String message;
    @CreationTimestamp
	private LocalDateTime TimeStamp;

	public ErrorResponse(int value, String message2, long timeMillis) {
		// TODO Auto-generated constructor stub
	}

}
