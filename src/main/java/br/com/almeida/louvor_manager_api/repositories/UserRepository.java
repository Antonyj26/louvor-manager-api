package br.com.almeida.louvor_manager_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.almeida.louvor_manager_api.entities.User;

public interface UserRepository extends JpaRepository<User, UUID>  {

	UserDetails findByEmail(String email);
}
