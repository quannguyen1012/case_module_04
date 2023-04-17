package com.cg.model.dto;

import java.util.List;
import java.util.Set;

public class RoleDto {
    private Long id;
    private String name;


    public RoleDto() {
    }

    public RoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDto(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


