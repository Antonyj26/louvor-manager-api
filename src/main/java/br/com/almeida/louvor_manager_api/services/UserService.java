package br.com.almeida.louvor_manager_api.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.almeida.louvor_manager_api.dto.UserDTO;
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
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User save(UserDTO userDTO) {
		
		if(userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
			throw new AppError("Email já cadastrado");
		}
		
		User user = new User();
		
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		
		if(userDTO.getRole() !=null) {
			user.setRole(userDTO.getRole());
		} else {
			user.setRole(UserRole.MEMBER);
		}
		
		return userRepository.save(user);
	}
}
