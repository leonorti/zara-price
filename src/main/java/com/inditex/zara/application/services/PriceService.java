package com.inditex.zara.application.services;

import org.springframework.stereotype.Component;

import com.inditex.zara.domain.dto.PriceResultDTO;

@Component
public interface PriceService {
    PriceResultDTO findPriceByFilter(String applicationDate, Long productId, Long brandId);
}
