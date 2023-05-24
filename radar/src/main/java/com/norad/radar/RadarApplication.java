package com.norad.radar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping
public class RadarApplication {

	/*
	private final String PATH = "http://localhost:8080/vuelosactivos/todos";
	WebClient webClient;
	
	
	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl(PATH).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	
	@GetMapping("/radar")
	public Flux<CabezaNuclearEnemiga> escanearTodosVuelos(){
		return webClient.get().uri("http://localhost:8080/vuelosactivos/todos").retrieve().bodyToFlux(CabezaNuclearEnemiga.class);
	}
	*/
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(RadarApplication.class, args);
		
	}

}
