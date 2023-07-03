/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infraestructure.exception.ServicioModuloException;
import com.inditex.zara.infraestructure.repository.PriceFilterRepository;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Clase controlador requerida por Spring Boot para funciones del modulo de
 * consulta de precios.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@RestController
@Validated
@CrossOrigin(origins = "*", maxAge = 3600)
public class PriceController {

	@Autowired
	private PriceFilterRepository repositorioPrecio;

	// Consulta por los filtros de la muestra SGMG
	@Operation(description = "Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:\r\n"
			+ "\r\n"
			+ "Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.\r\n"
			+ "Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.")
	@GetMapping({ "/prices" })
	@ResponseBody
	PriceResultDTO consultaPreciosPorFiltros(
			@RequestParam(required = false) @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss") String applicationDate,
			@RequestParam(required = false) Long productId,
			@RequestParam(required = false) Long brandId) {

		PriceResultDTO precio = null;
		try {
			precio = this.repositorioPrecio.consultarPrecio(applicationDate, productId, brandId);
		} catch (Exception e) {
			throw new ServicioModuloException();
		}
		return precio;
	}

}
