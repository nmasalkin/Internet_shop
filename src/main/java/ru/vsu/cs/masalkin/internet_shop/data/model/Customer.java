package ru.vsu.cs.masalkin.internet_shop.data.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(name = "customers_email_key", columnNames = {"email"})
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_gen")
    @SequenceGenerator(name = "customers_id_gen", sequenceName = "customers_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;


    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @Column(name = "patronymic", length = 50)
    private String patronymic;


    @Column(name = "address", nullable = false, length = 250)
    private String address;


    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}