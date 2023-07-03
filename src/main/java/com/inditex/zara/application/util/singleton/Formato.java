/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.util.singleton;

import java.sql.Timestamp;

/**
 * Clase Singleton Utilitaria para el formateo de datos.
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
public class Formato {

    private static Formato INSTANCE = null;

    private Formato() {
    }

    // Creador sincronizado para protegerse de posibles problemas multi-hilo
    // Otra prueba para evitar instanciación múltiple
    private static void createInstance() {
        if (INSTANCE == null) {
            // Solo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized (Formato.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) {
                    INSTANCE = new Formato();
                }
            }
        }
    }

    public static Formato getInstance() {
        if (INSTANCE == null)
            createInstance();
        return INSTANCE;
    }

    /**
     * Formateo de dato tipo Long
     * 
     * @param objectLong String
     * @return Long
     * @throws Exception
     */
    public Long getLong(Object objectLong) throws Exception {
        Long longValor = null;
        if (objectLong != null) {
            objectLong = String.valueOf(objectLong).replaceAll("\"", "");
        }
        longValor = Long.valueOf(String.valueOf(objectLong));
        return longValor;
    }

    /**
     * Formateo de dato tipo Float
     * 
     * @param objectFloat String
     * @return Float
     * @throws Exception
     */
    public Float getFloat(Object objectFloat) throws Exception {
        Float floatValor = null;
        floatValor = Float.valueOf(String.valueOf(objectFloat));
        return floatValor;
    }

    /**
     * Formateo de dato tipo Timestamp
     * 
     * @param objectTimestamp String
     * @return Timestamp
     * @throws Exception
     */
    public Timestamp getTimestamp(Object objectTimestamp) throws Exception {
        Timestamp timestampValor = null;
        timestampValor = Timestamp.valueOf(String.valueOf(objectTimestamp));
        return timestampValor;
    }

}
