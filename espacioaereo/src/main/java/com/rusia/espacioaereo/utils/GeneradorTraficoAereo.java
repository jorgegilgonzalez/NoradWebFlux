package com.rusia.espacioaereo.utils;

import java.time.Duration;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.rusia.espacioaereo.dto.MisilIntercontinental;
import com.rusia.espacioaereo.dto.ObjetoVolador;

import reactor.core.publisher.Flux;

public class GeneradorTraficoAereo {


	public static Flux<ObjetoVolador> generadorTrafico() {

		return Flux.interval(Duration.ofSeconds(2)).map(i -> vueloComercial());
		//return Flux.interval(Duration.ofSeconds(2)).map(i -> (i%2==0)?vueloComercial():lanzamientoMisil());
	}
		
		public static Flux<ObjetoVolador> lanzarMisiles(int numero) {

			return Flux.range(1,numero).map(i -> lanzamientoMisil());
			
		
		
	}

	public static ObjetoVolador vueloComercial() {

		Locale localeUSA = new Locale("en-US");

		String nombre = Faker.instance().aviation().aircraft();
		String origen = Faker.instance(localeUSA).aviation().airport();
		String destino = Faker.instance().aviation().airport();

		System.out.println(
				"Detectado vuelo comercial > " + nombre + " " + "Origen > " + origen + " " + "Destino > " + destino);
		return new ObjetoVolador(nombre, false, origen, destino);

	}

	public static ObjetoVolador lanzamientoMisil() {

		Locale localeUSA = new Locale("en-US");
		Locale localeSPAIN = new Locale("es-ES");

		String nombre = Faker.instance().space().moon();
		String origen = Faker.instance(localeUSA).address().cityName();
		String destino = Faker.instance(localeSPAIN).address().cityName();
		int megatones = (int) (1 + Math.random() * 20);

		System.out.println("Detectado vuelo > " + nombre + " " + "Origen > " + origen);
		return new MisilIntercontinental(nombre, true, origen, destino, megatones);

	}
}
