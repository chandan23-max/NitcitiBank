package com.cs.SpringSecurityWithJWT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs.SpringSecurityWithJWT.entity.User;
import com.cs.SpringSecurityWithJWT.repo.UserRepo;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {
   @Autowired
	private UserRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
		
	
	}
	@PostConstruct
	public void createUser() {
		List<User>user=Stream.of(new User(1, "chandan", "rani","chandan031999@gmail.com"),
				new User(2, "rahul", "raj","rahul031999@gmail.com")
				).collect(Collectors.toList());
				repo.saveAll(user);
		
		
	}
}
