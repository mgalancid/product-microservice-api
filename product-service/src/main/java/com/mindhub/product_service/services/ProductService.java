package com.mindhub.product_service.services;

import com.mindhub.product_service.dtos.NewProductEntityDTO;
import com.mindhub.product_service.dtos.ProductEntityDTO;

import java.util.List;

public interface ProductService {
    List<ProductEntityDTO> getAllProducts();
    List<ProductEntityDTO> getProductsById(List<Long> ids);
    ProductEntityDTO createProduct(NewProductEntityDTO newProduct);
    ProductEntityDTO updateProductStock(Long productId, Integer newStock);
}
