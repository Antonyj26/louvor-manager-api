package br.com.almeida.louvor_manager_api.dto;

import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.enums.InstrumentType;

public class ScaleDTO {

	private UUID id;
	private UUID eventId;
	private UUID userId;
	private InstrumentType function;

	public ScaleDTO() {
	}

	public ScaleDTO(UUID id, UUID eventId, UUID userId, InstrumentType function) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.userId = userId;
		this.function = function;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getEventId() {
		return eventId;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public InstrumentType getFunction() {
		return function;
	}

	public void setFunction(InstrumentType function) {
		this.function = function;
	}
	
	 
}
