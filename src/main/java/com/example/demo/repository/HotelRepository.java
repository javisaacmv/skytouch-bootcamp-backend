package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Hotel;

// @RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends MongoRepository<Hotel, String> {

    Page<Hotel> findAll(Pageable pageable);
    Page<Hotel> findByNameContainingIgnoreCase(String name, Pageable pageable);


}