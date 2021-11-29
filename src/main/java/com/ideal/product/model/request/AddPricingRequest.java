package com.ideal.product.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPricingRequest {

    private String productName;
    private String companyName;
    private String packingSize;
    private Double price;
    private String code;
}
