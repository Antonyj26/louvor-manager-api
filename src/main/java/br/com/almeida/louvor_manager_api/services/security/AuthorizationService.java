package br.com.almeida.louvor_manager_api.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.almeida.louvor_manager_api.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = repository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + username);
		}

		return user;
	}
}