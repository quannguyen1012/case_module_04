package com.cg.model.dto;

public class BrandDto {
    private Long id;
    private String brand;

    public BrandDto() {
    }

    public BrandDto(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public BrandDto(String brand) {
        this.brand = brand;
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
}
