/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entidad que hace referencia al objeto (tabla) mapeo ORM de la base de datos.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class PriceResultDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(name = "productId", type = "Long", example = "35455")
	private Long productId;

	@Schema(description = "Identificador de la Cadena.", name = "brandId", type = "Long", example = "1")
	private Long brandId;

	@Schema(description = "Identificador de la tarifa de precios aplicable.", name = "priceList", type = "Long", example = "1, 2, 3, 4")
	private Long priceList;

	@Schema(description = "Fecha incial en el que aplica el precio tarifa indicado.", name = "startDate", type = "date", example = "2020-06-15-11.00.00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	private Timestamp startDate;

	@Schema(description = "Fecha final en el que aplica el precio tarifa indicado.", name = "endDate", type = "date", example = "2020-06-15-11.00.00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	private Timestamp endDate;

	@Schema(description = "Precio final a aplicar.", name = "price", type = "String", example = "38.95")
	private float price;

	public PriceResultDTO() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}