package br.com.almeida.louvor_manager_api.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.almeida.louvor_manager_api.services.ScaleService;

@RestController
@RequestMapping(value = "/v1/scale")
public class ScaleController {
	
	private final ScaleService scaleService;
	
	public ScaleController(ScaleService scaleService) {
		this.scaleService = scaleService;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable UUID id) {
		
		scaleService.deleteScale(id);
		
	}
	
}
