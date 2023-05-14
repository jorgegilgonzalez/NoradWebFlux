package com.norad.radar.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.norad.radar.dto.Misil;

@Repository
public interface MisilRepository extends ReactiveCrudRepository<Misil, Integer>{

	
}
