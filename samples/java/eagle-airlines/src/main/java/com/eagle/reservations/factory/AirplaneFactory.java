package com.eagle.reservations.factory;

import java.util.ArrayList;
import java.util.List;

import com.eagle.reservations.model.Airplane;
import com.eagle.reservations.model.Seat;
import com.eagle.reservations.model.SeatType;

public class AirplaneFactory {

    private static long id = 1l;

    public static Airplane createAirplane(int firstClassSeats, int economyClassSeats) {
        List<Seat> seats = new ArrayList<>();

        int seatNumber = 1;

        // Create an amount of first class seats
        for (int i = 0; i < firstClassSeats; i++) {
            seats.add(createSeat(seatNumber++, SeatType.FIRST_CLASS));
        }

        // Create an amount of first class seats
        for (int i = 0; i < economyClassSeats; i++) {
            seats.add(createSeat(seatNumber++, SeatType.ECONOMY_CLASS));
        }

        return new Airplane(id++, seats);
    }

    public static Seat createSeat(int seatNumber, SeatType typeOfSeat) {
        return new Seat(seatNumber, typeOfSeat);
    }

    private AirplaneFactory() {
    }
}
