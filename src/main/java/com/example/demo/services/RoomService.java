package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.RoomModel;
import com.example.demo.repositories.RoomRepository;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public ArrayList<RoomModel> getAvalaibleRooms(){
        return (ArrayList<RoomModel>) roomRepository.findByAvailable(true);
    }
    
    public RoomModel saveRoom(RoomModel room){
        return roomRepository.save(room);
    }

    public Optional<RoomModel> getRoomById(Integer id){
        return roomRepository.findById(id);
    }
    
}
