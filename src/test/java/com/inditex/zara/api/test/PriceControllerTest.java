package com.inditex.zara.api.test;

import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infrastructure.adapters.web.PriceController;
import com.inditex.zara.application.exception.ModuleServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PriceControllerTest {
    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindPriceByFilter_WhenValidParams_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = "2023-07-18";
        Long productId = 123L;
        Long brandId = 456L;
        PriceResultDTO expectedResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(expectedResult);

        // Act
        PriceResultDTO result = priceController.findPriceByFilter(applicationDate, productId, brandId);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindPriceByFilter_WhenExceptionThrown_ReturnsModuleServiceException() {
        // Arrange
        String applicationDate = "2023-07-18";
        Long productId = 123L;
        Long brandId = 456L;
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenThrow(new RuntimeException());

        // Act & Assert
        assertThrows(ModuleServiceException.class, () ->
                priceController.findPriceByFilter(applicationDate, productId, brandId));
    }

}

