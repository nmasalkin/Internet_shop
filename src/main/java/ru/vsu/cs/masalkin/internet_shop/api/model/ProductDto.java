package ru.vsu.cs.masalkin.internet_shop.api.model;

import jakarta.persistence.Column;

public class ProductDto {

    private Integer id;

    private String title;

    private Integer price;

    private Integer weight;

    private String size;

    private String description;

    public ProductDto(String title, Integer price, Integer weight, String size, String description) {
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
