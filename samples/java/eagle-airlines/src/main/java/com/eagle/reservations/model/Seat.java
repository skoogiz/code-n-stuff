package com.eagle.reservations.model;

public class Seat {
    private final SeatType type;

    private int seatNumber;

    private boolean reserved = false;

    public Seat(int seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isNotReserved() {
        return !isReserved();
    }

    public void setUnreserved() {
        this.reserved = false;
    }

    public void setReserved() {
        this.reserved = true;
    }

}
