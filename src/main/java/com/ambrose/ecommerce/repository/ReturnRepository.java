package com.ambrose.ecommerce.repository;

import com.ambrose.ecommerce.entities.Returns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<Returns, String> {

}
