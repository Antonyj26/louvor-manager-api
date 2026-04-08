package br.com.almeida.louvor_manager_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almeida.louvor_manager_api.entities.Scale;

public interface ScaleRepository extends JpaRepository<Scale, UUID> {

}
