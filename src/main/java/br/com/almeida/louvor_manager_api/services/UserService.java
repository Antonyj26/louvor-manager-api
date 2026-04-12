package br.com.almeida.louvor_manager_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.almeida.louvor_manager_api.dto.UserDTO;
import br.com.almeida.louvor_manager_api.dto.UserResponseDTO;
import br.com.almeida.louvor_manager_api.entities.User;
import br.com.almeida.louvor_manager_api.entities.enums.UserRole;
import br.com.almeida.louvor_manager_api.exception.AppError;
import br.com.almeida.louvor_manager_api.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<UserResponseDTO> findAll() {

		return userRepository.findAll().stream().map(UserResponseDTO::new).toList();
	}

	public UserResponseDTO save(UserDTO userDTO) {

		User userIsPresent = (User) userRepository.findByEmail(userDTO.getEmail());
		
		if (userIsPresent != null) {
			throw new AppError("Email já cadastrado");
		}

		User user = new User();

		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(userDTO.getRole() != null ? userDTO.getRole() : UserRole.MEMBER);

		return new UserResponseDTO(userRepository.save(user));
	}

	public void delete(UUID id) {

		User user = userRepository.findById(id).orElseThrow(() -> new AppError("Usuário não encontrado"));

		userRepository.delete(user);

	}
}
