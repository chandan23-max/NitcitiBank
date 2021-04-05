package com.cs.SpringSecurityWithJWT.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cs.SpringSecurityWithJWT.service.CustomUserService;
import com.cs.SpringSecurityWithJWT.util.JwtUtil;

@Configuration
public class JwtFilter  extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/*
		 * Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWh1bCIsImV4cCI6MTYxNzY2NTU3NSwiaWF0IjoxNjE3NjI5NTc1fQ.UjVp8b_GrqhesixgUVB29xIiGNFXvopaFJPdOKaXaX8
		 */
		
		String authrizationHeader=request.getHeader("Authorization");
		String token=null;
		String username=null;
		if(authrizationHeader !=null&& authrizationHeader.startsWith("Bearer")) {
			token=authrizationHeader.substring(7);
			username=jwtUtil.extractUserName(token);
		}
			if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails  userDetails=service.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePassword=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					usernamePassword.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePassword);
					
					
				}
			}
			
			doFilter(request, response, filterChain);
		}
	

}
