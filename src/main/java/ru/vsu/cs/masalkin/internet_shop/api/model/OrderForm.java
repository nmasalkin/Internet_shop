package ru.vsu.cs.masalkin.internet_shop.api.model;

public class OrderForm {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private String email;
    private String paymentMethod;
    private int shippingCost;
    private int totalAmount;

    public OrderForm(String firstName, String lastName, String patronymic, String address, String phoneNumber, String email, String paymentMethod, int shippingCost, int totalAmount) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.patronymic = patronymic;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.paymentMethod = paymentMethod;
       this.shippingCost = shippingCost;
       this.totalAmount = totalAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
