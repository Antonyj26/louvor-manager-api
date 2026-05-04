package br.com.almeida.louvor_manager_api.services;

import java.util.List;
import java.util.UUID;

import br.com.almeida.louvor_manager_api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.almeida.louvor_manager_api.dto.EventDTO;
import br.com.almeida.louvor_manager_api.dto.ScaleDTO;
import br.com.almeida.louvor_manager_api.entities.Event;
import br.com.almeida.louvor_manager_api.entities.Scale;
import br.com.almeida.louvor_manager_api.entities.User;
import br.com.almeida.louvor_manager_api.exception.AppError;
import br.com.almeida.louvor_manager_api.repositories.EventRepository;
import br.com.almeida.louvor_manager_api.repositories.ScaleRepository;
import br.com.almeida.louvor_manager_api.repositories.UserRepository;
import br.com.almeida.louvor_manager_api.services.converter.EventConverter;

@Service
public class EventService {

	private final EventRepository eventRepository;
	private final UserRepository userRepository;
	private final ScaleRepository scaleRepository;

	public EventService(EventRepository eventRepository, UserRepository userRepository,
			ScaleRepository scaleRepository) {
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.scaleRepository = scaleRepository;
	}

	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {

		List<Event> listEvent = eventRepository.findAll();

		if (listEvent.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum evento encontrado");
		}

		return EventConverter.converter(listEvent);

	}

	public Event save(EventDTO eventDTO) {

		Event event = new Event();

		event.setDate(eventDTO.getDate());
		event.setTime(eventDTO.getTime());
		event.setDescription(eventDTO.getDescription());
		event.setName(eventDTO.getName());
		event.setType(eventDTO.getType());

		Event eventSave = eventRepository.save(event);

		if (eventDTO.getScales() != null) {
			for (ScaleDTO sDTO : eventDTO.getScales()) {

				Scale scale = new Scale();
				scale.setEvent(eventSave);
				scale.setFunction(sDTO.getFunction());

				User user = userRepository.findById(sDTO.getUserId()).orElseThrow(() -> new AppError("Usuário não encontrado"));

				scale.setUser(user);

				scaleRepository.save(scale);

				eventSave.getScales().add(scale);

			}
		}

		return eventSave;

	}

    @Transactional
    public void delete(UUID id){

        if(!eventRepository.existsById(id)){
            throw new ResourceNotFoundException("Evento não encotrado");
        }

        eventRepository.deleteById(id);

    }

}
