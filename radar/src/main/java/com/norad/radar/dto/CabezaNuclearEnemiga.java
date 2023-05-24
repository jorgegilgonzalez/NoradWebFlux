package com.norad.radar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CabezaNuclearEnemiga {

	
private String nombre;
private Boolean esMisilBalistico;
private String origen;
private String destino;
private int megatones;

}

