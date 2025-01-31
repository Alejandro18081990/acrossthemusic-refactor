package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo.entities","com.example.demo.services"})
	public class ApiAcrossMusicApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiAcrossMusicApplication.class, args);
	}
}
