package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RoomService;
import com.example.demo.models.RoomModel;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping()
    public ArrayList<RoomModel> getAvalaibleRooms(){
        return roomService.getAvalaibleRooms();
    }

    @PostMapping()
    @ResponseBody()
    public RoomModel saveRoom(@RequestBody RoomModel room){
        return this.roomService.saveRoom(room);
    }
    
}