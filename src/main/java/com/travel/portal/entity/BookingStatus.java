package com.travel.portal.entity;

public enum BookingStatus {
     CONFIRM("CONFIRM"), CANCEL("CANCEL"), ABORTED("ABORTED");

    private String bookingStatus;

    BookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }
}
