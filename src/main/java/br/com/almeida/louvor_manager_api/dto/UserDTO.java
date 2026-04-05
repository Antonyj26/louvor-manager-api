package br.com.almeida.louvor_manager_api.dto;

import br.com.almeida.louvor_manager_api.entities.enums.UserRole;

public class UserDTO {

	private String name;
	private String email;
	private String password;
	private UserRole role;

	public UserDTO() {
	}

	public UserDTO(String name, String email, String password, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}
