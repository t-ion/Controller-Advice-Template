package com.groupone.displayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DisplayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayServiceApplication.class, args);
	}

}