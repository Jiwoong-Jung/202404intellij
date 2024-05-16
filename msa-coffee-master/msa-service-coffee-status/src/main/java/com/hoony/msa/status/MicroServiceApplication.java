package com.hoony.msa.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
}
