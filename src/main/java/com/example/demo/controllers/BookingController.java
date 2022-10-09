package com.example.demo.controllers;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.RoomModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.BookingService;
import com.example.demo.services.RoomService;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;

    @PostMapping(path = "/{id_user}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public String reserveRoom( @PathVariable("id_user") Integer id_user, @RequestBody Map<String, String> json){
            Optional<UserModel> user = this.userService.getUserById(id_user);
            Integer id_room = Integer.parseInt(json.get("id_room"));
            Date fechaSalidaRes = Date.valueOf(json.get("fechaSalidaRes"));
            Date fechaIngresoRes = Date.valueOf(json.get("fechaIngresoRes"));
            Optional<RoomModel> room = this.roomService.getRoomById(id_room);
            if (user.isEmpty()){
                return "El usuario no existe";
            }
            
            if (room.isEmpty()){
                return "La habitacion no existe";
            }
            if (fechaIngresoRes.compareTo(fechaSalidaRes) > 0){
                return "La fecha de ingreso no puede ser menor a la fecha de salida";
            }
            RoomModel obj_room = room.get();
            UserModel obj_user = user.get();
            if(!obj_room.getAvailable()){
                obj_room.setFutureBookings(obj_room.getFutureBookings() + ","+ obj_user.getName());
                this.roomService.saveRoom(obj_room);
                return "La habitacion ya se encuentra reservada para ese rango de fechas";
            }
            obj_room.setAvailable(false);
            this.bookingService.createBooking(obj_room, obj_user, fechaIngresoRes, fechaSalidaRes, false, true);
            this.roomService.saveRoom(obj_room);
            return "Habitacion reservada correctamente";
    
    }
    
}