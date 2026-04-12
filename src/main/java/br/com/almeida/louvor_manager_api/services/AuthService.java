package br.com.almeida.louvor_manager_api.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.almeida.louvor_manager_api.dto.LoginDTO;
import br.com.almeida.louvor_manager_api.entities.User;
import br.com.almeida.louvor_manager_api.exception.AppError;
import br.com.almeida.louvor_manager_api.services.security.TokenService;

@Service
public class AuthService {
	
	private AuthenticationManager authenticationManager;
	private TokenService tokenService;
	
	public AuthService(@Lazy AuthenticationManager authenticationManager, TokenService tokenService) {
		this.authenticationManager = authenticationManager; 
		this.tokenService = tokenService;
	}

	public String login(LoginDTO data) {
		try {
			var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
	        
	        
	        var auth = this.authenticationManager.authenticate(usernamePassword);
	        
	        return tokenService.generateToken((User) auth.getPrincipal());
			
		} catch (BadCredentialsException e) {
			throw new AppError("Email ou senha inválidos");
		}
	}
	
	
}
