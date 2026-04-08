package br.com.almeida.louvor_manager_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeida.louvor_manager_api.dto.EventDTO;
import br.com.almeida.louvor_manager_api.entities.Event;
import br.com.almeida.louvor_manager_api.services.EventService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/event")
public class EventController {
	
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<EventDTO> findAll(){
		return eventService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Event> save(@RequestBody @Valid EventDTO eventDTO){
	
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(eventDTO));
		
		
	}

}
