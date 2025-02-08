package ru.vsu.cs.masalkin.internet_shop.api.model;

import ru.vsu.cs.masalkin.internet_shop.data.model.Order;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;
import ru.vsu.cs.masalkin.internet_shop.data.model.Product;

public class OrderProductDto {

    private OrderProductId id;

    private Order order;

    private Product product;

    private Integer quantity;

    public OrderProductDto(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
