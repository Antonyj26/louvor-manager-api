package br.com.almeida.louvor_manager_api.entities;

import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;	
	

	@Column(nullable = false)
	private String name;
	

	@Column(nullable = false, unique = true)
	private String email;	
	
   
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User() {
	}

	public User(UUID id, String name, String email, String password, UserRole role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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
