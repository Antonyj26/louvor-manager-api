package br.com.almeida.louvor_manager_api.services;

import java.util.List;
import java.util.UUID;

import br.com.almeida.louvor_manager_api.dto.ResponseDTO.EventResponseDTO;
import br.com.almeida.louvor_manager_api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.almeida.louvor_manager_api.dto.EventDTO;
import br.com.almeida.louvor_manager_api.dto.ScaleDTO;
import br.com.almeida.louvor_manager_api.entities.Event;
import br.com.almeida.louvor_manager_api.entities.Scale;
import br.com.almeida.louvor_manager_api.entities.User;
import br.com.almeida.louvor_manager_api.repositories.EventRepository;
import br.com.almeida.louvor_manager_api.repositories.ScaleRepository;
import br.com.almeida.louvor_manager_api.repositories.UserRepository;

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
	public List<EventResponseDTO> findAll() {

		List<Event> listEvent = eventRepository.findAll();

		if (listEvent.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum evento encontrado");
		}

		return listEvent.stream().map(EventResponseDTO::new).toList();

	}

	public EventResponseDTO save(EventDTO eventDTO) {

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

				User user = userRepository.findById(sDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

				scale.setUser(user);

				scaleRepository.save(scale);

				eventSave.getScales().add(scale);

			}
		}


		return new EventResponseDTO(eventSave);

	}

    @Transactional
    public void delete(UUID id){

        if(!eventRepository.existsById(id)){
            throw new ResourceNotFoundException("Evento não encotrado");
        }

        eventRepository.deleteById(id);

    }

    @Transactional
    public EventResponseDTO edit(EventDTO eventDTO){
        Event event = eventRepository.findById(eventDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Evento não econtrado"));

        event.setDate(eventDTO.getDate());
        event.setTime(eventDTO.getTime());
        event.setDescription(eventDTO.getDescription());
        event.setName(eventDTO.getName());
        event.setType(eventDTO.getType());

        if(eventDTO.getScales() != null){
            event.getScales().clear();

            for(ScaleDTO scaleDTO: eventDTO.getScales()){
                User user = userRepository.findById((scaleDTO.getUserId())).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

                Scale newScale = new Scale();
                newScale.setUser(user);
                newScale.setFunction(scaleDTO.getFunction());
                newScale.setEvent(event);

                event.getScales().add(newScale);
            }
        }

        Event eventSaved = eventRepository.save(event);

        return new EventResponseDTO(eventSaved);
    }

}
