package com.travel.portal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name = "CUST_BOOKING_ID", nullable = false, referencedColumnName = "BOOKING_ID")
    private Booking booking;
}
