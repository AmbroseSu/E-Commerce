package com.ambrose.ecommerce.repository;

import com.ambrose.ecommerce.entities.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, String> {

}
