package ru.vsu.cs.masalkin.internet_shop.api.model;

import jakarta.persistence.Column;

public class OrderProductIdDto {

    private Integer orderId;

    private Integer productId;

    public OrderProductIdDto(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
