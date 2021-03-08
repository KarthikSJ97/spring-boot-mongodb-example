package com.example.springbootwithmongodb.hotel;

import com.example.springbootwithmongodb.commons.CustomNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAll() {
        return this.hotelRepository.findAll();
    }

//  The insert() will add the resource. If a duplicate object id provided, it gives 500 error
    public Hotel addHotel(Hotel hotel) {
        return this.hotelRepository.insert(hotel);
    }

//  The save() will update a particular document and if id not provided, it will insert
    public Hotel updateHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    public Optional<Hotel> getById(String id) {
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if(hotel.isEmpty()) throw new CustomNotFoundException("Hotel details not found exception");
        return hotel;
    }

    public List<Hotel> getByPricePerNight(int maxPrice) {
        return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    public List<Hotel> getByCity(String city) {
        return this.hotelRepository.findByCity(city);
    }

}
