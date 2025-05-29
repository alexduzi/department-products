package com.alexduzi.departmentproducts.model.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table(value = "departments")
public class Department {

    @PrimaryKey
    private UUID id;

    private String name;

    public Department() {
    }

    public Department(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String name;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Department build() {
            Objects.requireNonNull(name, "Department name cannot be null");
            Objects.requireNonNull(id, "Department id cannot be null");

            if (name.trim().isBlank()) {
                throw new IllegalArgumentException("Department name cannot be blank");
            }

            return new Department(this);
        }
    }
}
