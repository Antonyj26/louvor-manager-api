package br.com.almeida.louvor_manager_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        eventService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
