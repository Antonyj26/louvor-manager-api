package br.com.almeida.louvor_manager_api.dto.ResponseDTO;

import br.com.almeida.louvor_manager_api.entities.Scale;
import br.com.almeida.louvor_manager_api.entities.enums.InstrumentType;

import java.util.UUID;

public class ScaleResponseDTO {
    private UUID id;
    private UserResponseDTO user; // Usa o seu DTO seguro
    private InstrumentType function;

    public ScaleResponseDTO() {
    }

    public ScaleResponseDTO(Scale scale) {
        this.id = scale.getId();
        this.user = new UserResponseDTO(scale.getUser());
        this.function = scale.getFunction();
    }

    public UUID getId() {
        return id;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public InstrumentType getFunction() {
        return function;
    }


}
