package com.alexduzi.departmentproducts.model.dto;

import com.alexduzi.departmentproducts.model.entities.Department;

import java.io.Serializable;
import java.util.UUID;

public class DepartmentDTO implements Serializable {

    private UUID id;

    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
