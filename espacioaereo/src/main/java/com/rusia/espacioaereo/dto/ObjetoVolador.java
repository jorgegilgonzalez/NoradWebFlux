package com.rusia.espacioaereo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjetoVolador {

private String nombre;
private Boolean esMisilBalistico;
private String origen;
private String destino;

}
