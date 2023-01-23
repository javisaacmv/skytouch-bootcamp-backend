package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;


@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "*")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @GetMapping()
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping("/paginated")
    public ResponseEntity<Map<String, Object>> getHotelsPaginated(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "") String name
    ){
        List<Hotel> hotels = new ArrayList<Hotel>();
        Pageable paging = PageRequest.of(page, size);
        Page<Hotel> pageHotels;
        if(name == "") pageHotels = hotelService.getHotelsPaginated( paging);
        else pageHotels = hotelService.getHotelsByNamePaginated(name, paging);
        hotels = pageHotels.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("hotels", hotels);
        response.put("currentPage", pageHotels.getNumber());
        response.put("totalItems", pageHotels.getTotalElements());
        response.put("totalPages", pageHotels.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable String id){
        return hotelService.getHotelById(id);
    }

    @PostMapping()
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable String id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id){
        hotelService.deleteHotel(id);
    }
}
