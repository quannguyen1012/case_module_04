package com.cg.model.dto;

public class CompanyDto {
    private Long id;
    private String company;

    public CompanyDto() {
    }

    public CompanyDto(Long id, String company) {
        this.id = id;
        this.company = company;
    }

    public CompanyDto(String company) {
        this.company = company;
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
}
