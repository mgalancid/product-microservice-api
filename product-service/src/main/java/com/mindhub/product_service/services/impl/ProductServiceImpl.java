package com.mindhub.product_service.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.mindhub.product_service.dtos.NewProductEntityDTO;
import com.mindhub.product_service.dtos.ProductEntityDTO;
import com.mindhub.product_service.dtos.order.OrderItemDTO;
import com.mindhub.product_service.exceptions.InsufficientStockException;
import com.mindhub.product_service.exceptions.ProductNotFoundException;
import com.mindhub.product_service.models.ProductEntity;
import com.mindhub.product_service.repositories.ProductRepository;
import com.mindhub.product_service.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntityDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductEntityDTO(product))
                .toList();
    }

    @Override
    public Optional<List<ProductEntityDTO>> getProductsById(List<Long> ids) {
        return productRepository.findAllById(ids)
                .stream()
                .map(ProductEntityDTO::new)
                .toList()
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of));
    }

    @Override
    public ProductEntityDTO createProduct(NewProductEntityDTO newProduct) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(newProduct.getName());
        productEntity.setDescription(newProduct.getDescription());
        productEntity.setPrice(newProduct.getPrice());
        productEntity.setStock(newProduct.getStock());

        ProductEntity savedProduct = productRepository.save(productEntity);
        return new ProductEntityDTO(savedProduct);
    }

    @Override
    public List<ProductEntityDTO> deductStock(List<OrderItemDTO> orderItemDTOs) {
        List<ProductEntity> products = new ArrayList<>();

        for (OrderItemDTO orderItem : orderItemDTOs) {
            Long productId = orderItem.getProductId();
            int quantity = orderItem.getQuantity();

            ProductEntity product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException(
                            "Product not found: " + productId)
                    );

            if (product.getStock() < quantity) {
                throw new InsufficientStockException(
                        "Insufficient stock for product: " + productId
                );
            }

            product.setStock(product.getStock() - quantity);
            products.add(product);
        }

        productRepository.saveAll(products);
        return products
                .stream()
                .map(item -> new ProductEntityDTO(item))
                .toList();
    }

    @Override
    public ProductEntityDTO updateProductStock(Long productId, Integer newStock) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);

        if (productEntity == null) {
            return null;
        }

        productEntity.setStock(newStock);
        ProductEntity updatedProduct = productRepository.save(productEntity);

        return new ProductEntityDTO(updatedProduct);
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public boolean existsByStock(Integer stock) {
        return productRepository.existsByStock(stock);
    }

    public ProductEntity findByName(String name) {
        return productRepository.findByName(name);
    }
}

