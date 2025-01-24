package com.mindhub.product_service.dtos;

import com.mindhub.product_service.models.ProductEntity;

public class NewProductEntityDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public NewProductEntityDTO(String name, String description, Double price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
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
