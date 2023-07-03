/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.infraestructure.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.zara.application.util.singleton.Formato;
import com.inditex.zara.application.util.singleton.Validacion;
import com.inditex.zara.domain.dto.PriceResultDTO;

/**
 * Interface que auto es implementada por Spring en el Bean Repositorio.
 * Para realizar las operaciones CRUD: Orientadas a Consultas (find).
 * 
 * @author Leonardo Ortiz
 * @version 1.0.0
 * @since 03/07/2023
 */
@Repository
public class PriceFilterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Funcion que organiza el query de consulta según los parametros ingresados por
     * el cliente.
     * 
     * @param applicationDate String
     * @param productId       Long
     * @param brandId         Long
     * @return List<Map<String, Object>>
     * @throws Exception
     */
    private List<Map<String, Object>> consultarFiltros(String applicationDate, Long productId, Long brandId)
            throws Exception {
        String sql = " select p.* from price p where 1=1 ";
        String where = "";

        // Rango de fechas
        if (Validacion.getInstance().isParam(applicationDate)) {
            where = where + " and p.START_DATE <= PARSEDATETIME('" + applicationDate
                    + "','yyyy-MM-dd-HH.mm.ss') and p.END_DATE >= PARSEDATETIME('" + applicationDate
                    + "','yyyy-MM-dd-HH.mm.ss') ";
        }

        // Id de producto
        if (Validacion.getInstance().isParam(productId)) {
            where = where + " and p.PRODUCT_ID = " + productId;
        }

        // Id cadena
        if (Validacion.getInstance().isParam(brandId)) {
            where = where + " and p.brand_id = " + brandId;
        }
        // Ordena por mayor prioridad
        where = where + " order by p.price_list desc limit 1 ";
        return this.jdbcTemplate.queryForList(sql + where);
    }

    /**
     * Funcion que ejecuta la consulta en la base de datos segun los parametros de
     * entrada para la consulta.
     * 
     * @param applicationDate String
     * @param productId       Long
     * @param brandId         Long
     * @return PriceResultDTO
     * @throws Exception
     */
    public PriceResultDTO consultarPrecio(String applicationDate, Long productId, Long brandId) throws Exception {
        PriceResultDTO precio = new PriceResultDTO();
        List<Map<String, Object>> precioList = this.consultarFiltros(applicationDate, productId, brandId);
        if (!precioList.isEmpty()) {
            Map<String, Object> precioMap = precioList.get(0);
            precio.setProductId(Formato.getInstance().getLong(precioMap.get("PRODUCT_ID")));
            precio.setBrandId(Formato.getInstance().getLong(precioMap.get("BRAND_ID")));
            precio.setPriceList(Formato.getInstance().getLong(precioMap.get("PRICE_LIST")));
            precio.setStartDate(Formato.getInstance().getTimestamp(precioMap.get("START_DATE")));
            precio.setEndDate(Formato.getInstance().getTimestamp(precioMap.get("END_DATE")));
            precio.setPrice(Formato.getInstance().getFloat(precioMap.get("PRICE")));
        }
        return precio;
    }

}
