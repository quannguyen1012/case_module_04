package com.cg.model.dto;

public class MadeInDto {

    private Long id;
    private String madeIn;

    public MadeInDto(Long id, String madeIn) {
        this.id = id;
        this.madeIn = madeIn;
    }

    public MadeInDto(String madeIn) {
        this.madeIn = madeIn;
    }

    public MadeInDto() {
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
}
