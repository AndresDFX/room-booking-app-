package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.RoomModel;

@Repository
public interface RoomRepository extends CrudRepository<RoomModel, Integer> {
    public abstract ArrayList<RoomModel> findByAvailable(boolean available);
    
    
}
