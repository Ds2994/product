package com.ideal.product.repository;

import com.ideal.product.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "SELECT * from company c where c.company_name = :name",nativeQuery = true)
    public Company findByCompanyName(@Param("name") String name);
}