package com.example.SpringToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToDoListApplication.class, args);
	}

}
