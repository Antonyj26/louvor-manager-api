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
import br.com.almeida.louvor_manager_api.entities.User;
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
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
		User user = userService.save(userDTO);
		
		return ResponseEntity.ok(user);
	}
}
