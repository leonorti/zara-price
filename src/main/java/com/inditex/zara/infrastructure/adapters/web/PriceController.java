/**
 * Copyright Inditex - Zara
 * @author Leonardo Ortiz
 * @email leonorti@gmail.com
 * @version 1.0.0
 * @since 03/07/2023
 */

package com.inditex.zara.infrastructure.adapters.web;

import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.application.services.impl.PriceServiceImpl;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.application.exception.ModuleServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin(origins = "*", maxAge = 3600)
public class PriceController {

    @Autowired
    private final PriceService priceService;

    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices")
    @ResponseBody
    public ResponseEntity<PriceResultDTO> findPriceByFilter(
            @RequestParam(required = false) String applicationDate,
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) Long brandId) {
        try {
            PriceResultDTO priceResultDTO = priceService.findPriceByFilter(applicationDate, productId, brandId);
            if (priceResultDTO != null) {
                return new ResponseEntity<>(priceResultDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(new PriceResultDTO(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // throw new ModuleServiceException();
            return new ResponseEntity<>(new PriceResultDTO(), HttpStatus.BAD_REQUEST);
        }
    }
}
