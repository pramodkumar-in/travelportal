package com.travel.portal.entity.converter;

import com.travel.portal.entity.PaymentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus paymentStatus) {

        if (paymentStatus == null)
            return null;
        return paymentStatus.getPaymentStatus();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }

        return Stream.of(PaymentStatus.values())
                .filter(c -> c.getPaymentStatus().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}

