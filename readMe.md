swagger-ui url http://localhost:8080/swagger-ui.html

Hotel booking json request

{
  "checkInDate": "2020-06-18T09:24:46.955Z",
  "checkOutDate": "2020-06-18T09:24:46.955Z",
  "customer": {
    "email": "string",
    "name": "string",
    "phoneNumber": 0
  },
  "name": "string",
  "rooms": [
    {
      "name": "string",
      "noOfGuests": 0,
      "roomType": "string"
    }
  ]
}

Booking response json
{
  "bookingStatus": "string",
  "checkInDate": "2020-06-18T09:24:46.982Z",
  "checkOutDate": "2020-06-18T09:24:46.982Z",
  "customer": {
    "email": "string",
    "id": 0,
    "name": "string",
    "phoneNumber": 0
  },
  "id": 0,
  "name": "string",
  "paymentStatus": "string",
  "rooms": [
    {
      "id": 0,
      "name": "string",
      "noOfGuests": 0,
      "roomPrice": 0,
      "roomType": "string",
      "status": true
    }
  ],
  "totalAmount": 0
}

Required entities:

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
    private List<Rooms> rooms = new ArrayList<>()
}

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




