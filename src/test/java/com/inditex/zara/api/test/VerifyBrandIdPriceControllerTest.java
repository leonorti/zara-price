package com.inditex.zara.api.test;

import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.application.services.impl.PriceServiceImpl;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infrastructure.adapters.web.PriceController;
import com.inditex.zara.application.exception.ModuleServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

class VerifyBrandIdPriceControllerTest {
    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @Test
    public void testFindPriceByFilter_WithBrandId_Success() {
        String applicationDate = "2023-08-08-12.00.00";
        Long productId = 1L;
        Long brandId = 2L;

        PriceResultDTO priceResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(priceResult);

        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                brandId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertSame(priceResult.getBrandId(), response.getBody().getBrandId());

    }

    @Test
    void testFindPriceByFilter_WhenRandomBrandId_ReturnsModuleServiceException() {
        String applicationDate = "2023-08-08-12.00.00";
        Long productId = 1L;
        Long brandId = getRandomBrandId();

        PriceResultDTO priceResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(priceResult);

        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                brandId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertSame(priceResult.getBrandId(), response.getBody().getBrandId());

    }

    private Long getRandomBrandId() {
        Random rand = new Random();
        return rand.nextLong();
    }
}
