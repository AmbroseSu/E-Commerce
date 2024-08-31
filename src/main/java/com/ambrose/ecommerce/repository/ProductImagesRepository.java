package com.ambrose.ecommerce.repository;

import com.ambrose.ecommerce.entities.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, String> {

}
