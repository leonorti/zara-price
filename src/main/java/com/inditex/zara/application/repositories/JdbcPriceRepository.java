/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */
package com.inditex.zara.application.repositories;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.zara.application.util.Format;
import com.inditex.zara.application.util.Validation;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.domain.repositories.PriceRepository;

@Repository
public class JdbcPriceRepository implements PriceRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    Format format;

    @Autowired
    Validation validation;

    @Autowired
    public JdbcPriceRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public PriceResultDTO findByFilters(String applicationDate, Long productId, Long brandId) throws Exception {
        PriceResultDTO priceResult = new PriceResultDTO();
        List<Map<String, Object>> priceList = this.findApplicationProductBrand(applicationDate, productId, brandId);
        if (!priceList.isEmpty()) {
            Map<String, Object> priceMap = priceList.get(0);
            priceResult.setProductId(format.getLong(priceMap.get("PRODUCT_ID")));
            priceResult.setBrandId(format.getLong(priceMap.get("BRAND_ID")));
            priceResult.setPriceList(format.getLong(priceMap.get("PRICE_LIST")));
            priceResult.setStartDate(format.getTimestamp(priceMap.get("START_DATE")));
            priceResult.setEndDate(format.getTimestamp(priceMap.get("END_DATE")));
            priceResult.setPrice(format.getFloat(priceMap.get("PRICE")));
        }
        return priceResult;
    }

    private List<Map<String, Object>> findApplicationProductBrand(String applicationDate, Long productId, Long brandId) throws Exception {
        String sql = "SELECT p.* FROM price p WHERE 1=1 ";
        String where = "";

        // Rango de fechas
        if (this.validation.isParam(applicationDate)) {
            where = where + " AND p.START_DATE <= PARSEDATETIME('" + applicationDate
                    + "','yyyy-MM-dd-HH.mm.ss') AND p.END_DATE >= PARSEDATETIME('" + applicationDate
                    + "','yyyy-MM-dd-HH.mm.ss') ";
        }

        // Id de producto
        if (this.validation.isParam(productId)) {
            where = where + " AND p.PRODUCT_ID = " + productId;
        }

        // Id cadena
        if (this.validation.isParam(brandId)) {
            where = where + " AND p.brand_id = " + brandId;
        }
        // Ordena por mayor prioridad
        where = where + " ORDER BY p.price_list DESC LIMIT 1 ";
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
    public PriceResultDTO findPrice(String applicationDate, Long productId, Long brandId) throws Exception {
        PriceResultDTO price = new PriceResultDTO();
        List<Map<String, Object>> priceList = this.findApplicationProductBrand(applicationDate, productId, brandId);
        if (!priceList.isEmpty()) {
            Map<String, Object> priceMap = priceList.get(0);
            price.setProductId(format.getLong(priceMap.get("PRODUCT_ID")));
            price.setBrandId(format.getLong(priceMap.get("BRAND_ID")));
            price.setPriceList(format.getLong(priceMap.get("PRICE_LIST")));
            price.setStartDate(format.getTimestamp(priceMap.get("START_DATE")));
            price.setEndDate(format.getTimestamp(priceMap.get("END_DATE")));
            price.setPrice(format.getFloat(priceMap.get("PRICE")));
        }
        return price;
    }
}
