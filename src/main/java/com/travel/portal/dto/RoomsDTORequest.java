package com.travel.portal.dto;

import com.travel.portal.entity.Booking;
import com.travel.portal.entity.RoomType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomsDTORequest {

    private String name;
    private String roomType;
    private int noOfGuests;

}
