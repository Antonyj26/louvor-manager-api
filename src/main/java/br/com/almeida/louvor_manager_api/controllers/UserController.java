package br.com.almeida.louvor_manager_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeida.louvor_manager_api.dto.UserDTO;
import br.com.almeida.louvor_manager_api.dto.UserResponseDTO;
import br.com.almeida.louvor_manager_api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/users")
public class UserController {

	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UserResponseDTO>> findAll(){
		return ResponseEntity.ok(userService.findAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
	}
}
