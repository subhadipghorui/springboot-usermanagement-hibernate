package com.springbooth2.sdg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Management", version = "2.0", description = "User Management API"))
public class SdgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdgApplication.class, args);
	}

}
