package com.ideal.product.repository;

import com.ideal.product.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends CrudRepository<Price, Long> {
}