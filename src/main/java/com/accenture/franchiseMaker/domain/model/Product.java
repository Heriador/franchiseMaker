package com.accenture.franchiseMaker.domain.model;

public class Product {

    private String name;
    private Long stock;

    public Product() {
    }

    public Product(String name, Long stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
