package com.rusia.espacioaereo.service;

import org.springframework.stereotype.Service;

import com.rusia.espacioaereo.dto.ObjetoVolador;
import com.rusia.espacioaereo.utils.GeneradorTraficoAereo;

import reactor.core.publisher.Flux;

@Service
public class EspacioAereoService {

	public Flux<ObjetoVolador> traficoAereo(){
		return GeneradorTraficoAereo.generadorTrafico();
	}
	
	public Flux<ObjetoVolador> lanzaMisiles(int numero){
		return GeneradorTraficoAereo.lanzarMisiles(numero);
	}
}
