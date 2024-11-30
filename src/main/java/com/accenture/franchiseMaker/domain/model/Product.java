package com.accenture.franchiseMaker.domain.model;

public class Product {

    private Long id;
    private String name;
    private Long stock;
    private Branch branch;

    public Product(Long id, String name, Long stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
