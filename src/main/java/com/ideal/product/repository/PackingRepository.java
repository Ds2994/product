package com.ideal.product.repository;

import com.ideal.product.entity.Packing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingRepository extends CrudRepository<Packing, Long> {

    @Query(value = "SELECT * FROM packing p WHERE p.packing_size = :size", nativeQuery = true)
    public Packing findByPackingSize(@Param("size") String size);
}
