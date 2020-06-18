package com.travel.portal.dto;

import com.travel.portal.entity.RoomType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomsDTOResponse {

    private Long id;
    private boolean status;
    private String name;
    private String roomType;
    private int noOfGuests;
    private double roomPrice;
}
