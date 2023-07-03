/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.util.singleton;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase Singleton Utilitaria para validaciones generales.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class Validacion {

    private static Validacion INSTANCE = null;

    private Validacion() {
    }

    // Creador sincronizado para protegerse de posibles problemas multi-hilo
    // Otra prueba para evitar instanciaci�n m�ltiple
    private static void createInstance() {
        if (INSTANCE == null) {
            // Solo se accede a la zona sincronizada
            // cuando la instancia no esta creada
            synchronized (Validacion.class) {
                // En la zona sincronizada seria necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) {
                    INSTANCE = new Validacion();
                }
            }
        }
    }

    public static Validacion getInstance() {
        if (INSTANCE == null)
            createInstance();
        return INSTANCE;
    }

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
