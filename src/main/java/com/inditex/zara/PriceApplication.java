/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase para el contexto Spring Security requerida por Spring Boot para
 * inicializar
 * del contexto.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.inditex.zara.domain")
@EntityScan(basePackages = "com.inditex.zara.domain.data")
@ComponentScan(basePackages = { "com.inditex.zara.infraestructure" })
public class PriceApplication {

	/**
	 * Inicio del microservicio
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
	}

}