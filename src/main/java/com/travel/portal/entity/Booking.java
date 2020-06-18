package com.travel.portal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "BOOKING")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "BOOKING_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CHECK_IN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;


    @Column(name = "CHECK_OUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;

    @Column(name = "PAYMENT_STATUS")
    private PaymentStatus paymentStatus;

    @Column(name = "BOOKING_STATUS")
    private BookingStatus bookingStatus;

    //@OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "booking")
    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "booking")
    private Customer customer;


    //@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "booking")
    private List<Rooms> rooms = new ArrayList<>();
}
