package ru.vsu.cs.masalkin.internet_shop.api.model;

import ru.vsu.cs.masalkin.internet_shop.data.model.CartId;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;
import ru.vsu.cs.masalkin.internet_shop.data.model.Product;

public class CartDto {

    private CartId id;

    private Customer customer;

    private Product product;

    private Integer quantity;

    public CartDto(Customer customer, Product product, Integer quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public CartId getId() {
        return id;
    }

    public void setId(CartId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
