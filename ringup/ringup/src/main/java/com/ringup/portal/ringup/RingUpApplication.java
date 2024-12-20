package com.ringup.portal.ringup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RingUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RingUpApplication.class, args);
	}

}
