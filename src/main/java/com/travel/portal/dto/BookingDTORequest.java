package com.travel.portal.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.travel.portal.entity.Customer;
import com.travel.portal.entity.Rooms;
import com.travel.portal.util.CustomDateDeserializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookingDTORequest {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;

    private CustomerDTORequest customer;
    private List<RoomsDTORequest> rooms = new ArrayList<>();
}
