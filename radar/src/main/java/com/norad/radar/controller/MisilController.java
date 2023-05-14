package com.norad.radar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norad.radar.dto.Misil;
import com.norad.radar.service.MisilService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
@RequestMapping("/misiles") // ruta base
public class MisilController {

	@Autowired
	MisilService misilService;

	// en la ruta raiz devuelve todos los misiles
	@GetMapping
	public Flux<Misil> getAll() {
		return misilService.getAll();
	}

	// subpath /id devuelve misil por id
	@GetMapping("/{id}")
	public Mono<Misil> getById(@PathVariable("id") int id) {
		return misilService.getById(id);
	}

	// crea nuevo misil
	@PostMapping
	public Mono<Misil> save(@RequestBody Misil misil) {
		return misilService.save(misil);
	}

	// subpath /id actualiza misil por id
	@PutMapping("/{id}")
	public Mono<Misil> update(@PathVariable("id") int id, @RequestBody Misil misil) {
		return misilService.update(id, misil);
	}

	// subpath /id borra misil por id
	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable("id") int id) {
		return misilService.delete(id);

	}
}
