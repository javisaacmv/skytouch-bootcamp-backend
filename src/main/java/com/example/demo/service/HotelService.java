package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotels(){
        return hotelRepository.findAll();
    }

    public Page<Hotel> getHotelsPaginated( Pageable page){
        return hotelRepository.findAll(page);
    }

    public Page<Hotel> getHotelsByNamePaginated(String name, Pageable page){
        return hotelRepository.findByNameContainingIgnoreCase(name, page);
    }

    public Hotel getHotelById(String id){
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel createHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(String id, Hotel hotel){
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);
        if(existingHotel != null){
            existingHotel.setName(hotel.getName());
            existingHotel.setAddress(hotel.getAddress());
            existingHotel.setRating(hotel.getRating());
            existingHotel.setAmenities(hotel.getAmenities());
            return hotelRepository.save(existingHotel);
        }
        return null;
    }

    public void deleteHotel(String id){
        hotelRepository.deleteById(id);
    }
}
