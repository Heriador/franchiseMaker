package com.accenture.franchiseMaker.domain.model;

import java.util.List;

public class Franchise {

    private Long id;
    private String name;
    private List<Branch> branches;

    public Franchise() {
    }

    public Franchise(Long id, String name, List<Branch> branches) {
        this.id = id;
        this.name = name;
        this.branches = branches;
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

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
