package com.ideal.product.repository;

import com.ideal.product.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p WHERE p.product_name = :name", nativeQuery = true)
    public Product findByProductName(@Param("name") String productName);
}
