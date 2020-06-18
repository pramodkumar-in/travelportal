package com.travel.portal.service;

import com.travel.portal.dto.BookingDTOResponse;
import com.travel.portal.dto.BookingDTORequest;
import com.travel.portal.entity.Booking;
import com.travel.portal.exceptions.EntityNotCreatedException;
import com.travel.portal.repository.BookingRepository;
import com.travel.portal.util.EntityDtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookingService")
public class BookingService {

    Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    @Qualifier("bookingRepository")
    private BookingRepository repository;

    @Transactional(readOnly = false)
    public BookingDTOResponse createOrder(BookingDTORequest request) {
        logger.info("start BookingService.createOrder(-) with request json "+request);
        Booking booking = EntityDtoConverter.getBookingEntityFromDTO(request);
        logger.info("BookingService.createOrder(-) with booking entity created from  "+booking);
        Booking bookingEntity = null;
        try {
            if (booking != null) {
                bookingEntity = repository.save(booking);
            }
        }catch (Exception e) {
            logger.warn("BookingService.createOrder(-) exception if booking entity is null  "+e);
            throw new EntityNotCreatedException(Booking.class, "id", booking.getName());
        }
        BookingDTOResponse response = EntityDtoConverter.getBookingDtoFromEntity(bookingEntity);

        if(response == null ) {
            logger.warn("BookingService.createOrder(-) exception if booking response is null");
            throw new EntityNotCreatedException(BookingDTOResponse.class, "id", booking.getName());
        }
       
        return response;

    }
}
