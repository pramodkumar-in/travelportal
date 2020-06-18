package com.travel.portal.repository;

import com.travel.portal.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
