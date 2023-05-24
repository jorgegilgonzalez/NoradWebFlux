package com.rusia.espacioaereo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class MisilIntercontinental extends ObjetoVolador {

	public MisilIntercontinental(String nombre, boolean esMisil, String origen, String destino, int megatones) {
		super(nombre, esMisil, origen,destino);
		
		this.megatones = megatones;
	}
	
int megatones;


@Override
public String toString() {
	
	return "Modelo: " + getNombre() + " // Origen: " + getOrigen() + " // Destino: "  + getDestino() + " // Megatones: " + megatones;
}

	

}


