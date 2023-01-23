package com.example.demo.model;

import org.springframework.data.annotation.Id;


public class Amenity {
    @Id private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
