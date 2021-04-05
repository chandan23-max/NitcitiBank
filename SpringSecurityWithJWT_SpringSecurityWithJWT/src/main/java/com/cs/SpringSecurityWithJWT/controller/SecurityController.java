package com.cs.SpringSecurityWithJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.SpringSecurityWithJWT.entity.RequestAuth;
import com.cs.SpringSecurityWithJWT.util.JwtUtil;

@RestController
public class SecurityController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@GetMapping("/")
	public String welcome() {

		return "Welcome to Cs Technologies";
	}

	@PostMapping("/auth")
	public String generateToken(@RequestBody RequestAuth reqAuth) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(reqAuth.getUserName(), reqAuth.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid username and password");
		}
		return jwtUtil.generarteToken(reqAuth.getUserName());
	}

}
