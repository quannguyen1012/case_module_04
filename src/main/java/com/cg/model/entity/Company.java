package com.cg.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    @OneToMany(targetEntity = Product.class)
    private List<Product> products;

    public Company(Long id, String company) {
        this.id = id;
        this.company = company;
    }

    public Company(String company) {
        this.company = company;
    }

    public Company() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
