package br.com.almeida.louvor_manager_api.services.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.almeida.louvor_manager_api.dto.EventDTO;
import br.com.almeida.louvor_manager_api.dto.ScaleDTO;
import br.com.almeida.louvor_manager_api.entities.Event;
import br.com.almeida.louvor_manager_api.entities.Scale;

public class EventConverter {

	public static List<EventDTO> converter(List<Event> origem) {

		List<EventDTO> list = new ArrayList<EventDTO>();

		for (Event e : origem) {

			EventDTO destino = new EventDTO();
			destino.setId(e.getId());
			destino.setDate(e.getDate());
			destino.setTime(e.getTime());
			destino.setDescription(e.getDescription());
			destino.setName(e.getName());
			destino.setType(e.getType());

			if (e.getScales() != null) {
				
				List<ScaleDTO> escalasDTO = new ArrayList<>();
				for (Scale s : e.getScales()) {
                    ScaleDTO sDTO = new ScaleDTO();
                    sDTO.setId(s.getId());
                    sDTO.setFunction(s.getFunction());
                    sDTO.setUserId(s.getUser().getId());
                    sDTO.setUserName(s.getUser().getName());
                    sDTO.setEventId(s.getEvent().getId());
                    
                    escalasDTO.add(sDTO);
				}
				
				destino.setScales(escalasDTO);
			}

			list.add(destino);

		}

		return list;

	}

}
