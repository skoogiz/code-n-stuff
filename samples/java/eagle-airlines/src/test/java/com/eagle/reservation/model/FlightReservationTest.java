package com.eagle.reservation.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eagle.reservations.factory.AirplaneFactory;
import com.eagle.reservations.model.Airplane;
import com.eagle.reservations.model.FlightReservation;
import com.eagle.reservations.model.Seat;
import com.eagle.reservations.model.SeatPrice;
import com.eagle.reservations.model.SeatType;

public class FlightReservationTest {

    private Airplane airplane;

    @Before
    public void init() {
        this.airplane = AirplaneFactory.createAirplane(4, 6);
    }

    @After
    public void tearDown() {
        this.airplane = null;
    }

    @Test
    public void testReservFirstClassSeat() {
        Optional<Seat> maybeSeat = airplane.getFirstAvailableSeatsByType(SeatType.FIRST_CLASS);
        assertTrue(maybeSeat.isPresent());

        Seat seat = maybeSeat.get();
        SeatPrice pricing = new SeatPrice();
        boolean food = true;

        FlightReservation reservation = new FlightReservation(airplane, seat, pricing, food);
        assertThat(reservation.getAirplaneId(), is(airplane.getId()));
        assertThat(reservation.getSeatId(), is(seat.getSeatNumber()));
        assertThat(reservation.getPrice(), is(20000.00f));
        assertTrue(reservation.wantsFood());
    }

}
