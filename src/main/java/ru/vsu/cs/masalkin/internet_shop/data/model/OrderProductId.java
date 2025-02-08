package ru.vsu.cs.masalkin.internet_shop.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class OrderProductId implements java.io.Serializable {
    private static final long serialVersionUID = -5811616245804157721L;
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderProductId entity = (OrderProductId) o;
        return Objects.equals(this.productId, entity.productId) &&
               Objects.equals(this.orderId, entity.orderId);
    }

    public int compareTo(OrderProductId anotherId) {
        return compare(this.orderId, anotherId.orderId);
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }

}