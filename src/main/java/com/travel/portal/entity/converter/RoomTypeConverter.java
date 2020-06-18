package com.travel.portal.entity.converter;

import com.travel.portal.entity.RoomType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class RoomTypeConverter implements AttributeConverter<RoomType, String> {
    @Override
    public String convertToDatabaseColumn(RoomType roomType) {

        if (roomType == null)
            return null;
        return roomType.getRoomCode();
    }

    @Override
    public RoomType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(RoomType.values())
                .filter(c -> c.getRoomCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
