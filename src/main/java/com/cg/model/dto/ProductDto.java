package com.cg.model.dto;

import java.util.Set;

public class ProductDto {
    private Long id;
    private Set<CategoryDto> categories;
    private String productCode;
    private String name;
    private String description;
    private Double price;
    private String image;
    private BrandDto brandDto;
    private CompanyDto companyDto;
    private MadeInDto madeInDto;

    public ProductDto(Long id, Set<CategoryDto> categories, String productCode, String name, String description, String genuineWarranty, String waterproof, String wireColor, String clockFace, String gender, String ropeType, String glassType,
                      String typeOfMachine, Double price, String image, BrandDto brandDto, CompanyDto companyDto, MadeInDto madeInDto) {
        this.id = id;
        this.categories = categories;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
//        this.genuineWarranty = genuineWarranty;
//        this.waterproof = waterproof;
//        this.wireColor = wireColor;
//        this.clockFace = clockFace;
//        this.gender = gender;
//        this.ropeType = ropeType;
//        this.glassType = glassType;
//        this.typeOfMachine = typeOfMachine;
        this.price = price;
        this.image = image;
        this.brandDto = brandDto;
        this.companyDto = companyDto;
        this.madeInDto = madeInDto;
    }

    public ProductDto(Set<CategoryDto> categories, String productCode, String name, String description, String genuineWarranty, String waterproof, String wireColor, String clockFace, String gender, String ropeType, String glassType, String typeOfMachine,
                      Double price, String image, BrandDto brandDto, CompanyDto companyDto, MadeInDto madeInDto) {
        this.categories = categories;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
//        this.genuineWarranty = genuineWarranty;
//        this.waterproof = waterproof;
//        this.wireColor = wireColor;
//        this.clockFace = clockFace;
//        this.gender = gender;
//        this.ropeType = ropeType;
//        this.glassType = glassType;
//        this.typeOfMachine = typeOfMachine;
        this.price = price;
        this.image = image;
        this.brandDto = brandDto;
        this.companyDto = companyDto;
        this.madeInDto = madeInDto;
    }

    public ProductDto() {

    }

//    public ProductDto(Long id, Set<CategoryDto> categories, String name, Double price,
//                      String image, BrandDto brandDto, CompanyDto companyDto, MadeInDto madeInDto) {
//        this.id = id;
//        this.categories = categories;
//        this.name = name;
//        this.price = price;
//        this.image = image;
//        this.brandDto = brandDto;
//        this.companyDto = companyDto;
//        this.madeInDto = madeInDto;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getGenuineWarranty() {
//        return genuineWarranty;
//    }
//
//    public void setGenuineWarranty(String genuineWarranty) {
//        this.genuineWarranty = genuineWarranty;
//    }
//
//    public String getWaterproof() {
//        return waterproof;
//    }
//
//    public void setWaterproof(String waterproof) {
//        this.waterproof = waterproof;
//    }
//
//    public String getWireColor() {
//        return wireColor;
//    }
//
//    public void setWireColor(String wireColor) {
//        this.wireColor = wireColor;
//    }
//
//    public String getClockFace() {
//        return clockFace;
//    }
//
//    public void setClockFace(String clockFace) {
//        this.clockFace = clockFace;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getRopeType() {
//        return ropeType;
//    }
//
//    public void setRopeType(String ropeType) {
//        this.ropeType = ropeType;
//    }
//
//    public String getGlassType() {
//        return glassType;
//    }
//
//    public void setGlassType(String glassType) {
//        this.glassType = glassType;
//    }
//
//    public String getTypeOfMachine() {
//        return typeOfMachine;
//    }
//
//    public void setTypeOfMachine(String typeOfMachine) {
//        this.typeOfMachine = typeOfMachine;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    public CompanyDto getCompanyDto() {
        return companyDto;
    }

    public void setCompanyDto(CompanyDto companyDto) {
        this.companyDto = companyDto;
    }

    public MadeInDto getMadeInDto() {
        return madeInDto;
    }

    public void setMadeInDto(MadeInDto madeInDto) {
        this.madeInDto = madeInDto;
    }
}
