package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestfulProj3CurdRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulProj3CurdRepoApplication.class, args);
	}

}
