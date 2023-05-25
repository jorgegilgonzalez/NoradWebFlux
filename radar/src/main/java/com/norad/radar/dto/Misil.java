package com.norad.radar.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "misiles") //tabla
@NoArgsConstructor //contructor vacio
//@AllArgsConstructor //contructor con todos los argumentos
@Data //getters y setters
public class Misil {

	public Misil(int id, String modelo, float alcance, int cantidad) {
		this.id = id;
		this.modelo = modelo;
		this.alcance = alcance;
		this.cantidad = cantidad;
	}
	@Id
	private int id;
	private String modelo;
	private float alcance;
	private int cantidad;
	
	/*
	public int getCantidad() {
		return this.cantidad;
	
	}*/
	
}
