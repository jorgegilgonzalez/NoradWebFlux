package com.norad.radar.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.norad.radar.dto.Misil;

import reactor.core.publisher.Mono;

@Repository
public interface MisilRepository extends ReactiveCrudRepository<Misil, Integer>{

	//necesito un metodo fuera del CrudRepository para encontrar un misil por nombre para checkear el error en caso de que coincidan dos nombres, por la restriccion unique del nombre en la bd, se define el metodo sin implementarlo por ser interfaz
	Mono<Misil> findByModelo(String modelo);
	
	@Query("SELECT * FROM misiles WHERE id<> :id AND modelo = :modelo")
	Mono<Misil> findModeloRepetido(int id, String modelo);
}
