package com.mindhub.product_service.repositories;

import com.mindhub.product_service.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntity, Long> {
}
