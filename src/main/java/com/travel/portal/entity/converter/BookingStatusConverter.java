package com.travel.portal.entity.converter;

import com.travel.portal.entity.BookingStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BookingStatusConverter implements AttributeConverter<BookingStatus, String> {
    @Override
    public String convertToDatabaseColumn(BookingStatus bookingStatus) {

        if (bookingStatus == null)
            return null;
        return bookingStatus.getBookingStatus();
    }

    @Override
    public BookingStatus convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }

        return Stream.of(BookingStatus.values())
                .filter(c -> c.getBookingStatus().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
