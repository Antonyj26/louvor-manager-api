package br.com.almeida.louvor_manager_api.dto.ResponseDTO;

public class LoginResponseDTO {

	private final String token;
	
	public LoginResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
}
