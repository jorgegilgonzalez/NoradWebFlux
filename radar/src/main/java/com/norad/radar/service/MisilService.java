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
		
		
		return misilRepository.findById(id)
				//control de errores, como es un mono, aunque no devuelva nada no salta error, generamos uno
				.switchIfEmpty(Mono.error(new Exception("Ese tipo de misil no existe")));
	}
	
	//metodo que deveulve el misil guardado 
	public Mono<Misil> save(Misil misil){
		//control de errores, comprueba si existe el modelo de misil ya en la bd
		Mono<Boolean> existeModelo = misilRepository.findByModelo(misil.getModelo()).hasElement();
		//devuelve por ternario un error si existe y si no guarda el misil
		return existeModelo.flatMap(e-> e ? Mono.error(new Exception("El modelo de misil ya existe en la BD")) : misilRepository.save(misil));
		
	}
	 //metodo que actualiza un misil dando el id y el misil(los nuevos datos)
	public Mono<Misil> update(int id, Misil misil){
		
				//control de errores, comprueba si existe el id del misil ya en la bd
				Mono<Boolean> existeId = misilRepository.findById(id).hasElement();
				//control de errores, comprueba si existe el modelo de misil ya en la bd
				Mono<Boolean> existeModelo = misilRepository.findModeloRepetido(id, misil.getModelo()).hasElement();
				
				
				//si existe el modelo de misil lanza error, de lo contrario, si el id es correcto actualizar el producto, de lo contrario lanza error de id no existe - if ternario anidado
				return existeId.flatMap(e-> e?
						existeModelo.flatMap(m -> m ?  Mono.error(new Exception("El modelo de misil ya existe en la BD"))
						: misilRepository.save(new Misil(id, misil.getModelo(), misil.getAlcance(),misil.getCantidad())))
						: Mono.error(new Exception("El id no coincide"))); 
					 
					 
		
	}
	
	//metodo que borra un misil por id
	public Mono<Void> delete(int id){
		
		//control de errores, comprueba si existe el id del misil ya en la bd
		Mono<Boolean> existeId = misilRepository.findById(id).hasElement();
		
		return existeId.flatMap(e->e ? misilRepository.deleteById(id) : Mono.error(new Exception("no se puede borrar, misil no encontrado")));
	}
}