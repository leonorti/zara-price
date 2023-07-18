package com.inditex.zara.application.services;

import com.inditex.zara.domain.dto.PriceResultDTO;

public interface PriceService {
    PriceResultDTO findPriceByFilter(String applicationDate, Long productId, Long brandId);
}
