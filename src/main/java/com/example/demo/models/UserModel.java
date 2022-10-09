package com.example.demo.models;


import javax.persistence.*;


@Entity
@Table(name = "users")
public class UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "user")
    private BookingModel booking;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}