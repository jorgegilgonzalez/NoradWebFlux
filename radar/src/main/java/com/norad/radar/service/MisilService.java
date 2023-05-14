package com.norad.radar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norad.radar.dto.Misil;
import com.norad.radar.repository.MisilRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@Slf4j para mostrar el logger
//@RequiredArgsConstructor //se pupede poner para no poner autowired, pero hay que hacerlo final
public class MisilService {

	@Autowired
	private MisilRepository misilRepository;
	
	//metodo que devuelve un flux con todos los misiles
	public Flux<Misil> getAll(){
		return misilRepository.findAll();
	}
	
	//metodo que devuelve un mono con el misil encontrado por id
	public Mono<Misil> getById(int id){
		return misilRepository.findById(id);
	}
	
	//metodo que deveulve el misil guardado 
	public Mono<Misil> save(Misil misil){
		return misilRepository.save(misil);
		
	}
	 //metodo que actualiza un misil dando el id y el misil(los nuevos datos)
	public Mono<Misil> update(int id, Misil misil){
		return misilRepository.save(new Misil(id, misil.getModelo(), misil.getAlcance()));
	}
	
	//metodo que borra un misil por id
	public Mono<Void> delete(int id){
		return misilRepository.deleteById(id);
	}
}
