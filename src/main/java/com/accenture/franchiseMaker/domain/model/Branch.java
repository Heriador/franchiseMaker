package com.accenture.franchiseMaker.domain.model;

import java.util.List;

public class Branch {

    private Long id;
    private String name;
    private List<Product> products;
    private Franchise franchise;

    public Branch() {
    }

    public Branch(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
