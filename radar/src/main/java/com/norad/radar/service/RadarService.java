package com.norad.radar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norad.radar.dto.Misil;
import com.norad.radar.repository.MisilRepository;

import reactor.core.publisher.Flux;

@Service
//@Slf4j para mostrar el logger
//@RequiredArgsConstructor //se pupede poner para no poner autowired, pero hay que hacerlo final
public class RadarService {

	@Autowired
	private MisilRepository misilRepository;
	
	//metodo que devuelve un flux con todos los misiles
	public Flux<Misil> getAll(){
		return misilRepository.findAll();
	}
	
	
	
}
