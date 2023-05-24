package com.norad.radar.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.norad.radar.handler.RadarHandler;

import lombok.extern.slf4j.Slf4j;

//router para manejar las rutas del handler
@Configuration
@Slf4j
public class RadarRouter {

	//path raiz que recibe las requests
	private static final String PATH = "radar";
	
	@Bean
	RouterFunction<ServerResponse> routerRadar(RadarHandler handler){
		return RouterFunctions.route()
				.GET(PATH, handler::getAll)
				.build();
		
	}
}
