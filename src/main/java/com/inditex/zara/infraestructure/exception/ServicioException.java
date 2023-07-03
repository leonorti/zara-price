/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.infraestructure.exception;

/**
 * Excepcion general para el manejo de los servicios de los microservicios.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class ServicioException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected String message = null;

    public ServicioException() {
        super("Excepcion general de servicios");
    }

    public ServicioException(Exception e) {
        super(e.getMessage());
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
