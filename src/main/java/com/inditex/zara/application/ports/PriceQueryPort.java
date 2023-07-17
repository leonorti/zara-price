/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */

package com.inditex.zara.application.ports;

import org.springframework.web.bind.annotation.RequestParam;

import com.inditex.zara.domain.dto.PriceResultDTO;

public interface PriceQueryPort {

    public PriceResultDTO findPriceByFilter(
            @RequestParam(required = false) String applicationDate,
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) Long brandId);

}
