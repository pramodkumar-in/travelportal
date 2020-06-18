package com.travel.portal.entity;

public enum PaymentStatus {

    PENDING("PENDING"), DECLINED("DECLINED"), UNAUTHORIZED("UNAUTHORIZED"),
      ABORTED("ABORTED"), SUCCESS("SUCCESS");

    private String paymentStatus;

    PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
