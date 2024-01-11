package com.demo.CarDatabase.controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CarDatabase.dto.AccountCredentials;
import com.demo.CarDatabase.services.JwtService;

@RestController
public class LoginController {
	
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getToken(@RequestBody
		      AccountCredentials credentials){
		UsernamePasswordAuthenticationToken authenticationToken = new
			      UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
		Authentication auth = authenticationManager.authenticate(authenticationToken);
		
		String jwts = jwtService.getToken(auth.getName());
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,
                "Bearer" + jwts).header(HttpHeaders.
                ACCESS_CONTROL_EXPOSE_HEADERS,
                "Authorization").build();
	}
	
}
