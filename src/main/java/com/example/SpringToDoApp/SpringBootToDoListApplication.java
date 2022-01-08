package com.example.SpringToDoApp;

import com.example.SpringToDoApp.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SpringBootToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToDoListApplication.class, args);
	}

}
