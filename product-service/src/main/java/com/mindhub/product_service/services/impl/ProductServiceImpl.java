package com.mindhub.product_service.services.impl;

import com.mindhub.product_service.dtos.NewProductEntityDTO;
import com.mindhub.product_service.dtos.ProductEntityDTO;
import com.mindhub.product_service.models.ProductEntity;
import com.mindhub.product_service.repositories.ProductRepository;
import com.mindhub.product_service.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
    public List<ProductEntityDTO> getProductsById(List<Long> ids) {
        List<ProductEntity> products = productRepository.findAllById(ids); // Fetch products from DB
        return products.stream()
                .map(product -> new ProductEntityDTO(product))
                .toList();
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
    public ProductEntityDTO updateProductStock(Long productId, Integer newStock) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);

        if (productEntity == null) {
            return null;
        }

        productEntity.setStock(newStock);
        ProductEntity updatedProduct = productRepository.save(productEntity);

        return new ProductEntityDTO(updatedProduct);
    }

    public boolean existsByProduct(ProductEntity product) {
        return productRepository.existsByProduct(product);
    }

    public boolean existsByStock(Integer stock) {
        return productRepository.existsByStock(stock);
    }

    public ProductEntity findByName(String name) {
        return productRepository.findByName(name);
    }
}

