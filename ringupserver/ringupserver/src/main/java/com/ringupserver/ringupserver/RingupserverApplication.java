package com.ringupserver.ringupserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RingupserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RingupserverApplication.class, args);
	}

}
