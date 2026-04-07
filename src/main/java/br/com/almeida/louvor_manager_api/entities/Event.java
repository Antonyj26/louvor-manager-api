package br.com.almeida.louvor_manager_api.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.almeida.louvor_manager_api.entities.enums.EventType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private LocalDate date;

	@Enumerated(EnumType.STRING)
	private EventType type;

	@Column(columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Scale> scales = new ArrayList<>();

	public Event() {
	}

	public Event(UUID id, String name, LocalDate date, EventType type, String description, List<Scale> scales) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
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

	public List<Scale> getScales() {
		return scales;
	}

}
