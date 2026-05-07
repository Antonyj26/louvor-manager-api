package br.com.almeida.louvor_manager_api.dto.ResponseDTO;

import br.com.almeida.louvor_manager_api.entities.Event;
import br.com.almeida.louvor_manager_api.entities.enums.EventType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class EventResponseDTO {

    private UUID id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private EventType type;
    private String description;
    private List<ScaleResponseDTO> scales;

    public EventResponseDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.time = event.getTime();
        this.type = event.getType();
        this.description = event.getDescription();
        // Transforma a lista de entidades em lista de DTOs usando o construtor acima
        this.scales = event.getScales().stream()
                .map(ScaleResponseDTO::new)
                .toList();
    }

    public List<ScaleResponseDTO> getScales() {
        return scales;
    }

    public String getDescription() {
        return description;
    }

    public EventType getType() {
        return type;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
