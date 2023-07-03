/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Clase para la verificacion de las pruebas unitarias JUnit del microservicio.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
class TestPriceController {

	private static final String URI = "http://localhost:8080/zara-price/prices/";

	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void test14junio10_whenPriceInfoIsRetrieved_thenPriceIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 1
		String test1 = "?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test1);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertEquals(Double.valueOf(35.50d), price);
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void test14junio16_whenPriceInfoIsRetrieved_thenPriceIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 2
		String test2 = "?applicationDate=2020-06-14-16.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test2);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertEquals(Double.valueOf(25.45d), price);
	}

	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void test14junio21_whenPriceInfoIsRetrieved_thenPriceIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 3
		String test3 = "?applicationDate=2020-06-14-21.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test3);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertEquals(Double.valueOf(35.50d), price);
	}

	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
	 * (ZARA)
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void test15junio10_whenPriceInfoIsRetrieved_thenPriceIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 4
		String test4 = "?applicationDate=2020-06-15-10.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test4);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertEquals(Double.valueOf(30.50d), price);
	}

	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
	 * (ZARA)
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void test16junio21_whenPriceInfoIsRetrieved_thenPriceIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 5
		String test5 = "?applicationDate=2020-06-16-21.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test5);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertEquals(Double.valueOf(38.95d), price);

	}

	/**
	 * Test 6: Validacion respuesta dato incorrecto de fecha
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void testFechaErrada_whenPriceInfoIsRetrieved_thenResponseNullIsReceived()
			throws ClientProtocolException, IOException, JSONException {

		// Consulta 6
		String test6 = "?applicationDate=2022-06-14-10.00.00&productId=35455&brandId=1";
		HttpUriRequest request = new HttpGet(URI + test6);

		// Solicitud
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Respuesta
		String json = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		JSONObject jsonObject = new JSONObject(json);
		double price = jsonObject.getDouble("price");

		// Verificacion
		assertNotNull(price);
	}
}
