package com.norad.radar.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.norad.radar.dto.Misil;
import com.norad.radar.service.MisilService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


//manera reactiva de manejar las rutas, de forma funcional en vez de la clasica MVC con el rest controller
@Component

public class MisilHandler {

	@Autowired
	private MisilService misilService;

	//dandole un serverRequest, devuelve un ServerResponse con un ok, y un flux de todos los misiles en json
	public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
		Flux<Misil> misiles = misilService.getAll();

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(misiles, Misil.class);
	}

	//dandole un serverRequest, devuelve un ServerResponse con un ok, y un mono del misil por id en json 
	public Mono<ServerResponse> getOne(ServerRequest serverRequest) {
		int id = Integer.valueOf(serverRequest.pathVariable("id"));
		Mono<Misil> misil = misilService.getById(id);

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(misil, Misil.class);

	}

	//dandole un serverRequest con un misil en el body, devuelve un ServerResponse con un ok, y guarda un misil que podemos ver en json 
	public Mono<ServerResponse> save(ServerRequest serverRequest) {
		Mono<Misil> misil = serverRequest.bodyToMono(Misil.class);

		return misil.flatMap(m -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(misilService.save(m),
				Misil.class));

	}

	//dandole un serverRequest con un id y un misil en el body, devuelve un ServerResponse con un ok, y guarda/actualiza el misil que podemos ver en json 
	public Mono<ServerResponse> update(ServerRequest serverRequest) {
		int id = Integer.valueOf(serverRequest.pathVariable("id"));
		Mono<Misil> misil = serverRequest.bodyToMono(Misil.class);

		return misil.flatMap(m -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(misilService.update(id, m), Misil.class));

	}
	
	
	

	//dandole un serverRequest con un id , devuelve un ServerResponse con un ok, y borra el misil que podemos ver en json 
	public Mono<ServerResponse> delete(ServerRequest serverRequest) {
		int id = Integer.valueOf(serverRequest.pathVariable("id"));

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(misilService.delete(id), Misil.class);

	}
}
