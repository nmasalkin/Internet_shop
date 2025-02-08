package ru.vsu.cs.masalkin.internet_shop.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartId implements Serializable {
    private static final long serialVersionUID = -5088089615275107958L;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartId entity = (CartId) o;
        return Objects.equals(this.productId, entity.productId) &&
               Objects.equals(this.customerId, entity.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, customerId);
    }
}