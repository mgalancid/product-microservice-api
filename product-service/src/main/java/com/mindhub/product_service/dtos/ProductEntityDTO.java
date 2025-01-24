package com.mindhub.product_service.dtos;

import com.mindhub.product_service.models.ProductEntity;

public class ProductEntityDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final Double price;
    private final Integer stock;

    public ProductEntityDTO(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
