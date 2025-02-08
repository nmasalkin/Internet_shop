package ru.vsu.cs.masalkin.internet_shop.api.model;

import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;

public class LoginInfoDto {

    private Integer id;

    private Customer customers;

    private String username;

    private String password;

    private String role;

    public LoginInfoDto(Customer customers, String username, String password, String role) {
        this.customers = customers;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
