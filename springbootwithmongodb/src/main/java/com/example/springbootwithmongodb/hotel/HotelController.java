package com.example.springbootwithmongodb.hotel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.CREATED);
    }
}
