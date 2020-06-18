package com.travel.portal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "ROOMS")
public class Rooms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long id;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "ROOM_NAME")
    private String name;

    @Column(name = "ROOM_TYPE")
    private RoomType roomType;

    @Column(name = "NO_OF_GUESTS")
    private int noOfGuests;

    @Column(name = "ROOM_PRICE")
    private double roomPrice;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "ROOM_BOOKING_ID", nullable = false)
    private Booking booking;
}
