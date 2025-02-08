package ru.vsu.cs.masalkin.internet_shop.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;

import java.time.LocalDate;

public class OrderDto {

    private Integer id;

    private Customer customer;

    private LocalDate registrationDate;

    private Integer shippingCost;

    private Integer orderCost;

    private String paymentMethod;

    private String status;

    public OrderDto(Customer customer, LocalDate registrationDate, Integer shippingCost, Integer orderCost, String paymentMethod, String status) {
        this.customer = customer;
        this.registrationDate = registrationDate;
        this.shippingCost = shippingCost;
        this.orderCost = orderCost;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Integer orderCost) {
        this.orderCost = orderCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
