package com.mindhub.product_service.controllers;

import com.mindhub.product_service.dtos.NewProductEntityDTO;
import com.mindhub.product_service.dtos.ProductEntityDTO;
import com.mindhub.product_service.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<List<ProductEntityDTO>> getAllProducts() {
        List<ProductEntityDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductEntityDTO> createProduct(@RequestBody NewProductEntityDTO newProduct) {
        ProductEntityDTO createdProduct = productService.createProduct(newProduct);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<ProductEntityDTO> updateProductStock(
            @PathVariable("id") Long productId,
            @RequestParam("newStock") Integer newStock) {
        ProductEntityDTO updatedProduct = productService.updateProductStock(productId, newStock);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }
}

