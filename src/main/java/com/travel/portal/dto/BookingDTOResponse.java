package com.travel.portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookingDTOResponse {

    private Long id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;
    private double totalAmount;
    private String paymentStatus;
    private String bookingStatus;
    private CustomerDTOResponse customer;
    private List<RoomsDTOResponse> rooms = new ArrayList<>();
}
