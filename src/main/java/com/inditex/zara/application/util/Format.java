/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.util;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * Clase Utilitaria para el formateo de datos.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@Component
public class Format {

    /**
     * Formateo de dato tipo Long
     * 
     * @param objectLong String
     * @return Long
     * @throws Exception
     */
    public Long getLong(Object objectLong) {
        Long longValue = null;
        if (objectLong != null) {
            objectLong = String.valueOf(objectLong).replaceAll("\"", "");
        }
        longValue = Long.valueOf(String.valueOf(objectLong));
        return longValue;
    }

    /**
     * Formateo de dato tipo Float
     * 
     * @param objectFloat String
     * @return Float
     * @throws Exception
     */
    public Float getFloat(Object objectFloat) {
        Float floatValue = null;
        floatValue = Float.valueOf(String.valueOf(objectFloat));
        return floatValue;
    }

    /**
     * Formateo de dato tipo Timestamp
     * 
     * @param objectTimestamp String
     * @return Timestamp
     * @throws Exception
     */
    public Timestamp getTimestamp(Object objectTimestamp) {
        Timestamp timestampValue = null;
        timestampValue = Timestamp.valueOf(String.valueOf(objectTimestamp));
        return timestampValue;
    }

}
