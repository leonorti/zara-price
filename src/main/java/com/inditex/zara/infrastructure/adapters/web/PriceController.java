/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */

package com.inditex.zara.infrastructure.adapters.web;

import com.inditex.zara.application.ports.PriceQueryPort;
import com.inditex.zara.application.repositories.JdbcPriceRepository;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infrastructure.exception.ModuleServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin(origins = "*", maxAge = 3600)
public class PriceController implements PriceQueryPort {

    @Autowired
    private JdbcPriceRepository repositorioPrecio;

    @GetMapping("/prices")
    @ResponseBody
    public PriceResultDTO findPriceByFilter(
            @RequestParam(required = false) String applicationDate,
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) Long brandId) {

        PriceResultDTO precio = null;

        try {
            precio = this.repositorioPrecio.findPrice(applicationDate, productId, brandId);
        } catch (Exception e) {
            throw new ModuleServiceException();
        }
        return precio;
    }
}
