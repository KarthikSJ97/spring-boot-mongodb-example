package com.example.springbootwithmongodb.hotel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hotel>> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(hotelService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/price/{maxPrice}")
    public ResponseEntity<List<Hotel>> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        return new ResponseEntity<>(hotelService.getByPricePerNight(maxPrice), HttpStatus.OK);
    }

    @GetMapping("/address/{city}")
    public ResponseEntity<List<Hotel>> getByCity(@PathVariable("city") String city){
        return new ResponseEntity<>(hotelService.getByCity(city), HttpStatus.OK);
    }
    
}
