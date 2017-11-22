package com.eagle.reservations.model;

import java.util.function.Function;

public class SeatPrice {

    public static final Function<Seat, Float> DEAFULT_PRICING = seat -> {
        if (SeatType.FIRST_CLASS == seat.getType()) {
            return 20000.00f;
        }
        return 5000.00f;
    };

    private Function<Seat, Float> getSeatPrice;

    public SeatPrice() {
        this(DEAFULT_PRICING);
    }

    public SeatPrice(Function<Seat, Float> getSeatPrice) {
        this.getSeatPrice = getSeatPrice;
    }

    public Float getPrice(Seat seat) {
        return getSeatPrice.apply(seat);
    }
}
