package br.com.almeida.louvor_manager_api.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.enums.EventType;

public class EventDTO {
	
	private UUID id;
	private String name;
	private LocalDate date;
	private LocalTime time;
	private EventType type;
	private String description;
	private List<ScaleDTO> scales = new ArrayList<>();

	public EventDTO() {
	}

	public EventDTO(UUID id, String name, LocalDate date, LocalTime time, EventType type, String description, List<ScaleDTO> scales) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.type = type;
		this.description = description;
		this.scales = scales;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ScaleDTO> getScales() {
		return scales;
	}

}
