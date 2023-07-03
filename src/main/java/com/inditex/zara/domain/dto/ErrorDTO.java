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
    private String codigo;
    private Date auditoria;
    private String mensaje;
    private String recurso;

    public ErrorDTO(String mensaje) {
        super();
        this.codigo = StringUtils.EMPTY;
        this.auditoria = new Date();
        this.mensaje = mensaje;
        this.recurso = "";
    }

    public ErrorDTO(Date auditoria, String mensaje, String recurso) {
        super();
        this.auditoria = auditoria;
        this.mensaje = mensaje;
        this.recurso = recurso;
    }

    public ErrorDTO(String codigo, Date auditoria, String mensaje, String recurso) {
        super();
        this.codigo = codigo;
        this.auditoria = auditoria;
        this.mensaje = mensaje;
        this.recurso = recurso;
    }

    public Date getAuditoria() {
        return auditoria;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

}
