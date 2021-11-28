package com.ideal.product.controller;

import com.ideal.product.service.PricingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("product/v1/pricing/")
public class PricingController {

    private PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        pricingService.savePricing();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
