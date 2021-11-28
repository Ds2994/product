package com.ideal.product.service;

import com.ideal.product.entity.Company;
import com.ideal.product.entity.Packing;
import com.ideal.product.entity.Product;
import com.ideal.product.entity.ProductPrice;
import com.ideal.product.repository.CompanyRepository;
import com.ideal.product.repository.PackingRepository;
import com.ideal.product.repository.ProductPriceRepository;
import com.ideal.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class PricingService {

    private ProductPriceRepository productPriceRepository;
    private PackingRepository packingRepository;
    private CompanyRepository companyRepository;
    private ProductRepository productRepository;

    public PricingService(ProductPriceRepository productPriceRepository, PackingRepository packingRepository, CompanyRepository companyRepository, ProductRepository productRepository) {
        this.productPriceRepository = productPriceRepository;
        this.packingRepository = packingRepository;
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
    }

    public void savePricing() {
        Packing packing = packingRepository.findByPackingSize("100 g");
        Product product = productRepository.findByProductName("Auramine O");
        Company company = companyRepository.findByCompanyName("SRL");

        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(product);
        productPrice.setCompany(company);
        productPrice.setPacking(packing);
        productPrice.setPrice(200.05);
        productPrice.setCreated(Timestamp.valueOf(LocalDateTime.now()));

        productPriceRepository.save(productPrice);
    }
}