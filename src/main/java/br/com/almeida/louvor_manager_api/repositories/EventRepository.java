package br.com.almeida.louvor_manager_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almeida.louvor_manager_api.entities.Event;

public interface EventRepository extends JpaRepository<Event, UUID> {

}
