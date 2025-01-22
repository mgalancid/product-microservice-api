package com.mindhub.product_service.dtos;

import com.mindhub.product_service.models.ProductEntity;

public class NewProductEntityDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public NewProductEntityDTO(ProductEntity product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
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
