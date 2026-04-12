package br.com.almeida.louvor_manager_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeida.louvor_manager_api.dto.LoginDTO;
import br.com.almeida.louvor_manager_api.dto.LoginResponseDTO;
import br.com.almeida.louvor_manager_api.services.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController {
	
	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
	
    @PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO data){
		String token = authService.login(data);
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
}
