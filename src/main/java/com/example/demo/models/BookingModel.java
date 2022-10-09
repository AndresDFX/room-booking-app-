package com.example.demo.models;


import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "booking")
public class BookingModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int code;

    @JoinColumn(name="room_id", unique = true, referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private RoomModel room;

    @JoinColumn(name="users_id", unique = true, referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserModel user;
    
    private Boolean finished=false;
    private Boolean active=true;

    @Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
    
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;

    
    public BookingModel(RoomModel room, UserModel user, Boolean finished, Boolean active,
            Date fechaIngresoRes, Date fechaSalidaRes) {
        this.room = room;
        this.user = user;
        this.finished = finished;
        this.active = active;
        this.fechaIngresoRes = fechaIngresoRes;
        this.fechaSalidaRes = fechaSalidaRes;
    }



    public BookingModel() {
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getFechaIngresoRes() {
        return fechaIngresoRes;
    }

    public void setFechaIngresoRes(Date fechaIngresoRes) {
        this.fechaIngresoRes = fechaIngresoRes;
    }

    public Date getFechaSalidaRes() {
        return fechaSalidaRes;
    }

    public void setFechaSalidaRes(Date fechaSalidaRes) {
        this.fechaSalidaRes = fechaSalidaRes;
    }

  



    
}
