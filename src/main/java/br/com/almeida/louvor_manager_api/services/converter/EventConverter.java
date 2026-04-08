package br.com.almeida.louvor_manager_api.services.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.almeida.louvor_manager_api.dto.EventDTO;
import br.com.almeida.louvor_manager_api.entities.Event;

public class EventConverter {
	
	public static List<EventDTO> converter(List<Event> origem){
		
		List<EventDTO> list = new ArrayList<EventDTO>();
		
		for(Event e : origem ) {
			
			EventDTO destino = new EventDTO();
			destino.setId(e.getId());
			destino.setDate(e.getDate());
			destino.setTime(e.getTime());
			destino.setDescription(e.getDescription());
			destino.setName(e.getName());
			destino.setType(e.getType());
			
			list.add(destino);
			
		}
		
		return list;
		
		
	}

}
