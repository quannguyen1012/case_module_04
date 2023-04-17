package com.cg.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class MadeIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String madeIn;
    @OneToMany(targetEntity = Product.class)
    private List<Product> products;

    public MadeIn(Long id, String madeIn) {
        this.id = id;
        this.madeIn = madeIn;
    }

    public MadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public MadeIn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
