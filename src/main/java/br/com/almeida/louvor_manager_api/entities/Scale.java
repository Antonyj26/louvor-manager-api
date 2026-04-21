package br.com.almeida.louvor_manager_api.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.almeida.louvor_manager_api.entities.enums.InstrumentType;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tb_scale")
public class Scale {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonIgnore
	private Event event;


	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Enumerated(EnumType.STRING)
	private InstrumentType function;

	public Scale() {
	}

	public Scale(UUID id, Event event, User user, InstrumentType function) {
		super();
		this.id = id;
		this.event = event;
		this.user = user;
		this.function = function;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InstrumentType getFunction() {
		return function;
	}

	public void setFunction(InstrumentType function) {
		this.function = function;
	}

}
