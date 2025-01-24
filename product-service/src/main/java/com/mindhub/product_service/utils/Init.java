package com.mindhub.product_service.utils;

import com.mindhub.product_service.models.ProductEntity;
import com.mindhub.product_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        ProductEntity product1 = new ProductEntity("Product 1",
                                                    "Description",
                                                    2.0,
                                                    1);
        productRepository.save(product1);
        ProductEntity product2 = new ProductEntity("Product 2",
                                                    "Description",
                                                    4.0,
                                                    1);
        productRepository.save(product2);
    }
}
