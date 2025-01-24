package com.mindhub.product_service.dtos.order;

public class OrderItemDTO {
    private final Long productId;
    private final Integer quantity;

    public OrderItemDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
