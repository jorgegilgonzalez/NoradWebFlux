package com.norad.radar.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.norad.radar.dto.CabezaNuclearEnemiga;
import com.norad.radar.service.MisilService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//manera reactiva de manejar las rutas, de forma funcional en vez de la clasica MVC con el rest controller
@Component
@Slf4j
public class RadarHandler {

	private final String PATH = "http://localhost:8080/vuelosactivos/todos";

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MisilService misilService;

	public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
		Flux<CabezaNuclearEnemiga> cabezasNuclearesEnemigas = getAll();

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cabezasNuclearesEnemigas,
				CabezaNuclearEnemiga.class);
	}

	// creamos una instancia del webClient reactivo que recoge un flux con los
	// elementos del otro servicio API
	public Flux<CabezaNuclearEnemiga> getAll() {

		return webClientBuilder.build().get().uri(PATH).retrieve().bodyToFlux(CabezaNuclearEnemiga.class)
				.doOnNext(e -> {
					if (e.getEsMisilBalistico()) {
						System.out.println("ALARMA !! " + e);
						//if (e.getMegatones()>8)
					}
				});

	}

}
