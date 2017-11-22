package com.eagle.reservations.model;

public class FlightReservation {
    private long airplaneId;
    private int seatId;
    private Float price;
    private boolean wantsFood;

    public FlightReservation(Airplane airplane, Seat seat, SeatPrice pricing, boolean wantsFood) {
        super();
        this.airplaneId = airplane.getId();
        this.seatId = seat.getSeatNumber();
        this.price = pricing.getPrice(seat);
        this.wantsFood = wantsFood;
    }

    public long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Airplane airplane) {
        this.airplaneId = airplane.getId();
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seat) {
        this.seatId = seat.getSeatNumber();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public boolean wantsFood() {
        return wantsFood;
    }

    public void setWantsFood(boolean wantsFood) {
        this.wantsFood = wantsFood;
    }

}
