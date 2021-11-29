package com.ideal.product.mapper;

import com.ideal.product.entity.Company;
import com.ideal.product.entity.Packing;
import com.ideal.product.entity.Price;
import com.ideal.product.entity.Product;
import com.ideal.product.model.request.AddPricingRequest;
import com.ideal.product.model.response.AddPricingResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class PricingMapper {

    public Price getPriceEntity(AddPricingRequest addPricingRequest, Product product, Company company, Packing packing) {
        Price price = new Price();
        price.setProduct(product);
        price.setCompany(company);
        price.setPacking(packing);
        price.setPrice(addPricingRequest.getPrice());
        price.setCode(addPricingRequest.getCode());
        price.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        return price;
    }

    public AddPricingResponse getPricingResponse(Price price) {
        return AddPricingResponse.builder()
                .id(price.getId())
                .productName(price.getProduct().getProductName())
                .companyName(price.getCompany().getCompanyName())
                .packingSize(price.getPacking().getPackingSize())
                .price(price.getPrice())
                .code(price.getCode()).build();
    }
}
