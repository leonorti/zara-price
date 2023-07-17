/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */

package com.inditex.zara.domain.repositories;

import com.inditex.zara.domain.dto.PriceResultDTO;

public interface PriceRepository {

    public PriceResultDTO findByFilters(String applicationDate, Long productId, Long brandId) throws Exception;

}
