package ru.vsu.cs.masalkin.internet_shop.api.model;

public class CartIdDto {

    private Integer customerId;

    private Integer productId;

    public CartIdDto(Integer customerId, Integer productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
