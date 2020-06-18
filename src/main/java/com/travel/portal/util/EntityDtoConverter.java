package com.travel.portal.util;

import com.travel.portal.dto.*;
import com.travel.portal.entity.*;
import com.travel.portal.exceptions.RequestDetailsNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityDtoConverter {

    static Logger logger = LoggerFactory.getLogger(EntityDtoConverter.class);

    private static Map<String, Double> roomPriceMap = new HashMap<>();
    /**
     * Similar info, can fetch from database
     * in case room available and respective cost stored in db,
     * Just hardcoded to perform functionality.
     * */
    static {
        roomPriceMap.put("SINGLE", 100.0);
        roomPriceMap.put("DOUBLE", 200.0);
    }

    public static Booking getBookingEntityFromDTO(BookingDTORequest dto) {

        Booking booking = new Booking();
        booking.setName(dto.getName());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setPaymentStatus(PaymentStatus.PENDING);
        booking.setBookingStatus(BookingStatus.CONFIRM);
        CustomerDTORequest customerDTO = dto.getCustomer();
        if(customerDTO == null) {
            logger.info("EntityDtoConverter.getBookingEntityFromDTO() in booking request json " +
                    "customer details not available");
            throw new RequestDetailsNotValidException(Customer.class, "customer Details not found in Request json");
        }
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        booking.setCustomer(customer);

        double totalAmount = 0.0;
        if (dto.getRooms().size() > 0) {
            List<Rooms> rooms = new ArrayList<>();
            Rooms room = null;

            for(RoomsDTORequest roomsDTO : dto.getRooms()) {
                room = new Rooms();
                room.setName(roomsDTO.getName());
                room.setRoomType(RoomType.valueOf(roomsDTO.getRoomType()));
                room.setStatus(true);
                room.setNoOfGuests(roomsDTO.getNoOfGuests());
                totalAmount = totalAmount + roomPriceMap.get(roomsDTO.getName());
                room.setRoomPrice(roomPriceMap.get(roomsDTO.getName()));
                rooms.add(room);
            }
            booking.setRooms(rooms);
        } else {
            logger.info("EntityDtoConverter.getBookingEntityFromDTO() in booking request json " +
                    "room details not available");
            throw new RequestDetailsNotValidException(Rooms.class, "Room Details not found in Request json");
        }
        booking.setTotalAmount(totalAmount);

        return booking;

    }

    public static BookingDTOResponse getBookingDtoFromEntity(Booking booking) {

        BookingDTOResponse bookingDTO = new BookingDTOResponse();
        bookingDTO.setId(booking.getId());
        bookingDTO.setName(booking.getName());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setTotalAmount(booking.getTotalAmount());
        bookingDTO.setPaymentStatus(booking.getPaymentStatus().getPaymentStatus());
        bookingDTO.setBookingStatus(booking.getBookingStatus().getBookingStatus());

        Customer customer = booking.getCustomer();
        CustomerDTOResponse customerDTO = new CustomerDTOResponse();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        bookingDTO.setCustomer(customerDTO);


        if (booking.getRooms().size() > 0) {
            List<RoomsDTOResponse> rooms = new ArrayList<>();
            RoomsDTOResponse roomsDTO = null;
            for(Rooms room : booking.getRooms()) {
                roomsDTO = new RoomsDTOResponse();
                roomsDTO.setId(room.getId());
                roomsDTO.setName(room.getName());
                roomsDTO.setRoomType(room.getRoomType().getRoomCode());
                roomsDTO.setNoOfGuests(room.getNoOfGuests());
                roomsDTO.setRoomPrice(room.getRoomPrice());
                rooms.add(roomsDTO);
            }
            bookingDTO.setRooms(rooms);
        }

        return bookingDTO;

    }
}
