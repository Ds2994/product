package com.ideal.product.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddPricingResponse {

    private Long id;
    private String productName;
    private String companyName;
    private String packingSize;
    private Double price;
    private String code;
}
