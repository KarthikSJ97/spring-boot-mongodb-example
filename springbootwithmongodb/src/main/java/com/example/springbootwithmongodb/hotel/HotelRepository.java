package com.example.springbootwithmongodb.hotel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

//  using the supported keywords for query methods
//  For more info https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html
    public List<Hotel> findByPricePerNightLessThan(int maxPrice);
}
