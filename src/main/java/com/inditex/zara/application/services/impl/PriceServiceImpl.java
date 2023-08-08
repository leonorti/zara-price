package com.inditex.zara.application.services.impl;

import com.inditex.zara.application.exception.ModuleServiceException;
import com.inditex.zara.application.ports.PriceQueryPort;
import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.domain.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService, PriceQueryPort {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResultDTO findPriceByFilter(String applicationDate, Long productId, Long brandId) {
        try {
            return priceRepository.findByFilters(applicationDate, productId, brandId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ModuleServiceException();
        }
    }
}
