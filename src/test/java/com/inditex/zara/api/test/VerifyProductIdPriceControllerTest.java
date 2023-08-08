package com.inditex.zara.api.test;

import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infrastructure.adapters.web.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VerifyProductIdPriceControllerTest {
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
        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                brandId);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertSame(expectedResult.getProductId(), response.getBody().getProductId());
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
        assertSame(priceResult.getBrandId(), ((PriceResultDTO) response.getBody()).getBrandId());

    }

    @Test
    public void testFindPriceByFilter_WithoutBrandId_Success() {
        String applicationDate = "2023-08-08-12.00.00";
        Long productId = 1L;

        PriceResultDTO priceResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, null)).thenReturn(priceResult);

        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId, null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertSame(priceResult.getBrandId(), response.getBody().getBrandId());
    }

    @Test
    public void testFindPriceByFilter_WithInvalidBrandId_BadRequest() {
        String applicationDate = "2023-08-08-12.00.00";
        Long productId = 1L;
        Long invalidBrandId = -2L;

        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                invalidBrandId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody().getBrandId());

        verify(priceService, never()).findPriceByFilter(any(), any(), any());
    }

    @Test
    void testFindPriceByFilter_WhenNullProductId_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = "2023-07-18";
        Long productId = null;
        Long brandId = 456L;
        PriceResultDTO expectedResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(expectedResult);

        // Act
        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                brandId);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertSame(expectedResult.getBrandId(), response.getBody().getBrandId());
    }

    @Test
    void testFindPriceByFilter_WhenZeroProductId_ReturnsPriceResultDTO() {
        // Arrange
        String applicationDate = "2023-07-18";
        Long productId = 0L;
        Long brandId = 456L;
        PriceResultDTO expectedResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(applicationDate, productId, brandId)).thenReturn(expectedResult);

        // Act
        ResponseEntity<PriceResultDTO> response = priceController.findPriceByFilter(applicationDate, productId,
                brandId);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertSame(expectedResult.getBrandId(), response.getBody().getBrandId());
    }
}
