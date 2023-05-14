package com.norad.radar.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "misiles") //tabla
@NoArgsConstructor //contructor vacio
@AllArgsConstructor //contructor con todos los argumentos
@Data //getters y setters
public class Misil {

	@Id
	private int id;
	private String modelo;
	private float alcance;
	
}
