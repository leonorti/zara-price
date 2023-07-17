/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.domain.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * DTO para la captura de la Excepcion detallada para el manejo de los servicios
 * de los microservicios.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class ErrorDTO {
    private String code;
    private Date audit;
    private String message;
    private String resource;

    public ErrorDTO(String mensaje) {
        super();
        this.code = StringUtils.EMPTY;
        this.audit = new Date();
        this.message = mensaje;
        this.resource = "";
    }

    public ErrorDTO(Date audit, String message, String resource) {
        super();
        this.audit = audit;
        this.message = message;
        this.resource = resource;
    }

    public ErrorDTO(String code, Date audit, String message, String resource) {
        super();
        this.code = code;
        this.audit = audit;
        this.message = message;
        this.resource = resource;
    }

    public Date getAudit() {
        return audit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResource() {
        return resource;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

}
