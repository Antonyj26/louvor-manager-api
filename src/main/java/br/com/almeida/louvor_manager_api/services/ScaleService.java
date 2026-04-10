package br.com.almeida.louvor_manager_api.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.almeida.louvor_manager_api.entities.Scale;
import br.com.almeida.louvor_manager_api.exception.AppError;
import br.com.almeida.louvor_manager_api.repositories.ScaleRepository;

@Service
public class ScaleService {

	private final ScaleRepository scaleRepository;

	public ScaleService(ScaleRepository scaleRepository) {
		this.scaleRepository = scaleRepository;
	}

	public void deleteScale(UUID id) {
		Scale scale = scaleRepository.findById(id).orElseThrow(() -> new AppError("Escala não encotrada"));

		scaleRepository.delete(scale);

	}

}
