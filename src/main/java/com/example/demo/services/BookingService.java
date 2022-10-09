package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.BookingModel;
import com.example.demo.models.RoomModel;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.RoomRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    
    public BookingModel createBooking(RoomModel room, UserModel user, Date fechaIngresoRes, Date fechaSalidaRes, Boolean finished, Boolean active){
        BookingModel booking = new BookingModel(room, user, finished, active, fechaIngresoRes, fechaSalidaRes);

        return bookingRepository.save(booking);
    }
    
}
