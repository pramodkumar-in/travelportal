package com.travel.portal.dto;
import com.travel.portal.entity.Booking;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTORequest {

    private String name;
    private String email;
    private Long phoneNumber;
}
