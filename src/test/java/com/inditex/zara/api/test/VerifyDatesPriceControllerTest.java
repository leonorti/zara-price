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

class VerifyDatesPriceControllerTest {
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
    void testFindPriceByFilter_WhenInvalidDate_ReturnsModuleServiceException() {
        // Arrange
        String applicationDate = "2023-07-18-10.00.00"; // Invalid date format
        Long productId = 123L;
        Long brandId = 456L;

        // Act & Assert
        assertThrows(ModuleServiceException.class, () ->
                priceController.findPriceByFilter(applicationDate, productId, brandId));
    }

    @Test
    void testFindPriceByFilter_WhenNullDate_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = null;
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
    void testFindPriceByFilter_WhenEmptyDate_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = "";
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
    void testFindPriceByFilter_WhenBlankDate_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = "   ";
        Long productId = 123L;
        Long brandId = 456L;
        PriceResultDTO expectedResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(expectedResult);

        // Act
        PriceResultDTO result = priceController.findPriceByFilter(applicationDate, productId, brandId);

        // Assert
        assertEquals(expectedResult, result);
    }
}
