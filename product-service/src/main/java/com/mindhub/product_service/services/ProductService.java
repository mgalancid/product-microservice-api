package com.mindhub.product_service.services;

import com.mindhub.product_service.dtos.NewProductEntityDTO;
import com.mindhub.product_service.dtos.ProductEntityDTO;
import com.mindhub.product_service.dtos.order.OrderItemDTO;

import java.util.List;

public interface ProductService {
    List<ProductEntityDTO> getAllProducts();
    List<ProductEntityDTO> getProductsById(List<Long> ids);
    List<ProductEntityDTO> deductStock(List<OrderItemDTO> orderItemDTO);
    ProductEntityDTO createProduct(NewProductEntityDTO newProduct);
    ProductEntityDTO updateProductStock(Long productId, Integer newStock);
}
