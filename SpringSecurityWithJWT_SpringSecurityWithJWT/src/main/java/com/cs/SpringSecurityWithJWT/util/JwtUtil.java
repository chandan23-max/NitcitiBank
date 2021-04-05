package com.cs.SpringSecurityWithJWT.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String secret = "rahul";

	public String extractUserName(String token) {

		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExperion(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean JsTokenExpired(String token) {
		// here it will check if the token has created before time limit 10 hours then
		// will return true or false
		return extractExperion(token).before(new Date());

	}

	/*
	 * this method is for generating the token as a argument is username so user
	 * first time send request with username and password so here we will fetch the
	 * username,based on that username we are going to create one token
	 */
	public String generarteToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	/*
	 * Here we are validating the token
	 */

	public Boolean validateToken(String token, UserDetails userDetails) {

		// basically token will be generated in encrypted string and from that string we
		// extract our username and password using expression

		final String username = extractUserName(token);

		return (username.equals(userDetails.getUsername()) && !JsTokenExpired(token));

	}

}
