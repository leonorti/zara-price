/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.infrastructure.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.inditex.zara.domain.dto.ErrorDTO;

/**
 * Excepcion general para el manejo de los servicios de los microservicios.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@ControllerAdvice
public class ModuleServiceException extends ServiceException {

	private static final long serialVersionUID = 1L;

	/**
	 * Funcion encargada de gestionar la excepcion del servicio y presentar la
	 * respuesta al cliente.
	 * 
	 * @param e       Exception
	 * @param request WebRequest
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ Exception.class, ServiceException.class })
	public ResponseEntity<?> globleExceptionHandler(Exception e, WebRequest request) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter((Writer) errors));
		if (e.getMessage() == null) {
			super.message = errors.toString();
		} else {
			super.message = e.getMessage();
		}
		ErrorDTO errorDTO = new ErrorDTO(new Date(), super.message, request.getDescription(false));
		e.printStackTrace();
		return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}