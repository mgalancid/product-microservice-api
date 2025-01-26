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
        ProductEntity product1 = new ProductEntity("Laptop Gamer Acer Nitro 5",
                                                   "Potente laptop para juegos con tarjeta gráfica NVIDIA RTX 3060," +
                                                        " procesador Intel Core i7 y 16GB de RAM.",
                                                   1299.99,
                                                   10);
        productRepository.save(product1);

        ProductEntity product2 = new ProductEntity("Smartphone Samsung Galaxy S23 Ultra",
                                                   "El smartphone más avanzado de Samsung con cámara de 200MP," +
                                                           " pantalla Dynamic AMOLED 2X y carga súper rápida.",
                                                   1199.99,
                                                   8);
        productRepository.save(product2);

        ProductEntity product3 = new ProductEntity("Smart TV LG OLED55C2",
                                                   "Televisor OLED de 55 pulgadas con resolución 4K, " +
                                                        "HDR Dolby Vision y sistema operativo webOS.",
                                                   1999.99,
                                                   5);
        productRepository.save(product3);

        ProductEntity product4 = new ProductEntity("Consola PlayStation 5 Digital Edition",
                                                   "La última generación de consolas de Sony, " +
                                                           "con un diseño elegante y una biblioteca de juegos exclusiva.",
                                                   499.99,
                                                   15);
        productRepository.save(product4);
    }
}

