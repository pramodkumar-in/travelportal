package com.travel.portal.controller;


import com.travel.portal.dto.BookingDTOResponse;
import com.travel.portal.dto.BookingDTORequest;
import com.travel.portal.exceptions.EntityNotCreatedException;
import com.travel.portal.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreateOrderController {

    Logger logger = LoggerFactory.getLogger(CreateOrderController.class);

    @Autowired
    @Qualifier("bookingService")
    private BookingService service;

    /**
     * getBooking(-) method return list bookings.
      */
    @GetMapping("/order/get/{bookingId}")
    public List<BookingDTOResponse> getBooking(@PathVariable("bookingId") Long bookingId ) {

        return new ArrayList<>();

    }


    @PostMapping("/order/create")
    public BookingDTOResponse createOrder (@RequestBody BookingDTORequest request) throws EntityNotCreatedException {
        logger.info("start CreateOrderController.createOrder(-) method with booking request :"+request);
        BookingDTOResponse response = service.createOrder(request);
        logger.info("end CreateOrderController.createOrder(-) method with booking response :"+response);
        return response;
    }
}
