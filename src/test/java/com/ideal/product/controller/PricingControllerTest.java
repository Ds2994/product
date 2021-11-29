package com.ideal.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideal.product.model.request.AddPricingRequest;
import com.ideal.product.model.response.AddPricingResponse;
import com.ideal.product.service.PricingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PricingController.class)
public class PricingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingService pricingService;

    @Test
    void test_addPricing_success() throws Exception {
        when(pricingService.addPricing(createAddPricingRequest())).thenReturn(Optional.ofNullable(createAddPricingResponse()));
        mockMvc.perform(post("/product/v1/pricing/add").content(toJson(createAddPricingRequest()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void test_addPricing_failure() throws Exception {
        when(pricingService.addPricing(createAddPricingRequest())).thenReturn(Optional.empty());
        mockMvc.perform(post("/product/v1/pricing/add").content(toJson(createAddPricingRequest()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    private String toJson(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private AddPricingRequest createAddPricingRequest() {
        AddPricingRequest addPricingRequest = new AddPricingRequest();
        addPricingRequest.setProductName("Ammonium");
        addPricingRequest.setCompanyName("SRL");
        addPricingRequest.setPackingSize("500 g");
        addPricingRequest.setPrice(200.05);
        addPricingRequest.setCode("123534");
        return addPricingRequest;
    }

    private AddPricingResponse createAddPricingResponse() {
        AddPricingResponse addPricingResponse = new AddPricingResponse();
        addPricingResponse.setId(1L);
        addPricingResponse.setProductName("Ammonium");
        addPricingResponse.setCompanyName("SRL");
        addPricingResponse.setPackingSize("500 g");
        addPricingResponse.setPrice(200.05);
        addPricingResponse.setCode("123534");
        return addPricingResponse;
    }
}
