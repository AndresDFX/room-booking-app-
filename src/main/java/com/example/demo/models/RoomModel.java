package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "room")
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name= "num_of_persons", nullable = false)
    private Integer numOfPersons;

    @OneToOne(mappedBy = "room")
    private BookingModel booking;

    @Column(name= "amount", nullable = false)
    private Double amount;

    private Boolean available=true;

    @Column(name="future_bookings", nullable = true)
    private String futureBookings;
    

    public RoomModel(int id, Integer numOfPersons, BookingModel booking, Double amount, Boolean available) {
        this.id = id;
        this.numOfPersons = numOfPersons;
        this.booking = booking;
        this.amount = amount;
        this.available = true;
    }
    
    public RoomModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumOfPersons() {
        return numOfPersons;
    }

    public void setNumOfPersons(Integer numOfPersons) {
        this.numOfPersons = numOfPersons;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getFutureBookings() {
        return futureBookings;
    }

    public void setFutureBookings(String futureBookings) {
        this.futureBookings = futureBookings;
    }

}
