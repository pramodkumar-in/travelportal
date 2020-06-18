package com.travel.portal.entity;

public enum RoomType {

    SINGLE ("SINGLE"),
    DOUBLE ("DOUBLE");

    private String roomCode;

    RoomType(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }
}
