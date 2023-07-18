/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.exception;

/**
 * Excepcion general para el manejo de los servicios de los microservicios.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected String message = null;

    public ServiceException() {
        super("Excepcion general de servicios");
    }

    public ServiceException(Exception e) {
        super(e.getMessage());
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
