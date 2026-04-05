package br.com.almeida.louvor_manager_api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almeida.louvor_manager_api.entities.User;

public interface UserRepository extends JpaRepository<User, UUID>  {

	Optional<User> findByEmail(String email);
}
