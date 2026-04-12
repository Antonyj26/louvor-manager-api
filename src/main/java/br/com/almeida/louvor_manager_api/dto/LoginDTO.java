package br.com.almeida.louvor_manager_api.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

	@NotBlank(message = "O e-mail é obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	private String password;

	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

}
