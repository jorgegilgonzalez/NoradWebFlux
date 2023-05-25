package com.rusia.espacioaereo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rusia.espacioaereo.dto.ObjetoVolador;
import com.rusia.espacioaereo.service.EspacioAereoService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/vuelosactivos")
public class EspacioAereoController {

	@Autowired
	EspacioAereoService espacioAereo;

	@GetMapping(value = "/todos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ObjetoVolador> vuelos(){
		return espacioAereo.traficoAereo();
	}
	
	
	@GetMapping(value = "/lanzaMisiles/{numero}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ObjetoVolador> lanzaMisiles(@PathVariable ("numero") int numero){
		return espacioAereo.lanzaMisiles(numero);
	}
	
	@GetMapping(value = "/trafico/{numero}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ObjetoVolador> traficoFlux(@PathVariable ("numero") int numero){
		
		return  espacioAereo.ataqueMezclado(numero);
				
				
	}
}
