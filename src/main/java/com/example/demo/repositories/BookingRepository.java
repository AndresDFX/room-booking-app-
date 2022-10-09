package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BookingModel;

@Repository
public interface BookingRepository extends CrudRepository<BookingModel, Integer> {
   
    
}
