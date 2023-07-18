/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Clase Utilitaria para validaciones generales.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@Component
public class Validation {


    /**
     * Metodo que valida si el parametro es valido
     * 
     * @param param object
     * @return boolean
     * @throws Exception
     */
    public boolean isParam(Object param) throws Exception {
        boolean isParam = false;
        if (param != null && !param.equals(StringUtils.EMPTY)) {
            isParam = true;
        }
        return isParam;
    }

}
