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

}
