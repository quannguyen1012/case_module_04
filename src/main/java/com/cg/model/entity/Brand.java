package com.cg.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;

    @OneToMany(targetEntity = Product.class)
    private List<Product> products;
    public Brand(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Brand(String brand) {
        this.brand = brand;
    }

    public Brand() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
