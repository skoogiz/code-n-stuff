package com.eagle.reservation.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.eagle.reservations.factory.AirplaneFactory;
import com.eagle.reservations.model.Seat;
import com.eagle.reservations.model.SeatPrice;
import com.eagle.reservations.model.SeatType;

public class SeatTest {

    @Test
    public void testSeatPricing() {
        Seat seat;
        SeatPrice pricing = new SeatPrice();

        // Test FIRST CLASS seats
        seat = AirplaneFactory.createSeat(1, SeatType.FIRST_CLASS);
        assertNotNull(seat);
        assertThat(pricing.getPrice(seat), is(20000.00f));

        // Test ECONOMY CLASS seats
        seat = AirplaneFactory.createSeat(2, SeatType.ECONOMY_CLASS);
        assertNotNull(seat);
        assertThat(pricing.getPrice(seat), is(5000.00f));
    }

}
