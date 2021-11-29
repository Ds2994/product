package com.ideal.product.service;

import com.ideal.product.entity.Company;
import com.ideal.product.entity.Packing;
import com.ideal.product.entity.Product;
import com.ideal.product.entity.Price;
import com.ideal.product.mapper.PricingMapper;
import com.ideal.product.model.request.AddPricingRequest;
import com.ideal.product.model.response.AddPricingResponse;
import com.ideal.product.repository.CompanyRepository;
import com.ideal.product.repository.PackingRepository;
import com.ideal.product.repository.ProductPriceRepository;
import com.ideal.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PricingService {

    private ProductPriceRepository productPriceRepository;
    private PackingRepository packingRepository;
    private CompanyRepository companyRepository;
    private ProductRepository productRepository;
    private PricingMapper pricingMapper;

    public PricingService(ProductPriceRepository productPriceRepository, PackingRepository packingRepository, CompanyRepository companyRepository, ProductRepository productRepository, PricingMapper pricingMapper) {
        this.productPriceRepository = productPriceRepository;
        this.packingRepository = packingRepository;
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
        this.pricingMapper = pricingMapper;
    }

    public void savePricing() {
        Packing packing = packingRepository.findByPackingSize("100 g");
        Product product = productRepository.findByProductName("Auramine O");
        Company company = companyRepository.findByCompanyName("SRL");

        Price price = new Price();
        price.setProduct(product);
        price.setCompany(company);
        price.setPacking(packing);
        price.setPrice(200.05);
        price.setCreated(Timestamp.valueOf(LocalDateTime.now()));

        productPriceRepository.save(price);
    }

    public Optional<AddPricingResponse> addPricing(AddPricingRequest addPricingRequest) {
        try {
            Product product = productRepository.findByProductName(addPricingRequest.getProductName());
            Company company = companyRepository.findByCompanyName(addPricingRequest.getCompanyName());
            Packing packing = packingRepository.findByPackingSize(addPricingRequest.getPackingSize());
            Price price = pricingMapper.getPriceEntity(addPricingRequest, product, company, packing);
            Price insertedPrice = productPriceRepository.save(price);
            AddPricingResponse addPricingResponse = pricingMapper.getPricingResponse(insertedPrice);
            return Optional.of(addPricingResponse);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}