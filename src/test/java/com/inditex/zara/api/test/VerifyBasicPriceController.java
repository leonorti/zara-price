package com.inditex.zara.api.test;

import com.inditex.zara.application.services.impl.PriceServiceImpl;
import com.inditex.zara.domain.dto.PriceResultDTO;
import com.inditex.zara.infrastructure.adapters.web.PriceController;
import com.inditex.zara.application.exception.ModuleServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class VerifyBasicPriceController {

    @Mock
    private PriceServiceImpl priceService;

    @InjectMocks
    private PriceController priceController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @Test
    public void testFindPriceByFilter_Success() throws Exception {
        PriceResultDTO priceResult = new PriceResultDTO();
        when(priceService.findPriceByFilter(any(), any(), any())).thenReturn(priceResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("applicationDate", "2023-08-08T12:00:00")
                .param("productId", "1")
                .param("brandId", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(priceService, times(1)).findPriceByFilter(any(), any(), any());
    }

}
