package br.com.almeida.louvor_manager_api.entities;

import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.enums.InstrumentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_scale")
public class Scale {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user_id")
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
