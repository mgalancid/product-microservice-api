package com.mindhub.product_service.repositories;

import com.mindhub.product_service.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <ProductEntity, Long> {
    ProductEntity findByName(String name);
    boolean existsById(Long id);
    boolean existsByStock(Integer stock);
    List<ProductEntity> findAllByIdIn(List<Long> ids);
}
