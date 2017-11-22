package com.eagle.reservation.factory;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.eagle.reservations.factory.AirplaneFactory;
import com.eagle.reservations.model.Airplane;
import com.eagle.reservations.model.Seat;
import com.eagle.reservations.model.SeatType;

public class AirplaneFactoryTest {

    @Test
    public void testCreateAirplane() {
        Airplane airplane = AirplaneFactory.createAirplane(4, 6);

        assertNotNull(airplane);
        assertNotNull(airplane.getId());
        assertThat(airplane.getNumberOfSeats(), is(10));
        assertThat(airplane.getSeatsByType(SeatType.FIRST_CLASS).size(), is(4));
        assertThat(airplane.getSeatsByType(SeatType.ECONOMY_CLASS).size(), is(6));
    }

    @Test
    public void testCreateSeat() {
        Seat seat;

        // Test FIRST CLASS seats
        seat = AirplaneFactory.createSeat(1, SeatType.FIRST_CLASS);
        assertNotNull(seat);
        assertThat(seat.getSeatNumber(), is(1));
        assertThat(seat.getType(), is(SeatType.FIRST_CLASS));

        // Test ECONOMY CLASS seats
        seat = AirplaneFactory.createSeat(2, SeatType.ECONOMY_CLASS);
        assertNotNull(seat);
        assertThat(seat.getSeatNumber(), is(2));
        assertThat(seat.getType(), is(SeatType.ECONOMY_CLASS));
    }

}
