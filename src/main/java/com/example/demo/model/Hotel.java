package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    @Id private String _id;

    private String name;
    private String address;
    private Float rating;

    private List<String> amenities = new ArrayList<String>();

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<String> getAmenities() {
        return amenities;
    }
}