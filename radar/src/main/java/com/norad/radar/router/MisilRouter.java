package com.norad.radar.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.norad.radar.handler.MisilHandler;

import lombok.extern.slf4j.Slf4j;

//router para manejar las rutas del handler
@Configuration
@Slf4j
public class MisilRouter {

	//path raiz que recibe las requests
	private static final String PATH = "misilesrouter";
	
	@Bean
	RouterFunction<ServerResponse> router(MisilHandler handler){
		return RouterFunctions.route()
				.GET(PATH, handler::getAll)
				.GET(PATH + "/{id}", handler::getOne)
				.POST(PATH, handler::save)
				.PUT(PATH + "/{id}", handler::update)
				.DELETE(PATH + "/{id}", handler::delete)
				.build();
		
	}
}
