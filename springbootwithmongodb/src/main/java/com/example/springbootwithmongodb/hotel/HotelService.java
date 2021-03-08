package com.example.springbootwithmongodb.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

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

}
