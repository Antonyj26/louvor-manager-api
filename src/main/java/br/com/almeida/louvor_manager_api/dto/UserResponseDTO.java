package br.com.almeida.louvor_manager_api.dto;

import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.User;
import br.com.almeida.louvor_manager_api.entities.enums.UserRole;

public class UserResponseDTO {

	private UUID id;
	private String name;
	private String email;
	private UserRole role;

	public UserResponseDTO() {
	}

	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.role = user.getRole();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}
