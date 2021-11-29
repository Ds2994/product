package com.ideal.product.controller;

import com.ideal.product.model.request.AddPricingRequest;
import com.ideal.product.service.PricingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product/v1/pricing/")
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

    @PostMapping("add")
    public ResponseEntity addPricing(@RequestBody AddPricingRequest addPricingRequest) {
        return pricingService.addPricing(addPricingRequest)
                .map(pricingResponse -> new ResponseEntity<>(pricingResponse, HttpStatus.CREATED))
                .orElse(ResponseEntity.internalServerError()
                        .build());
    }
}