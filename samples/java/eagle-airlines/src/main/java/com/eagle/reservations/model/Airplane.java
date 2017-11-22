package com.eagle.reservations.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Airplane {

    private final List<Seat> seats;

    private long id;

    public Airplane(long id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public Optional<Seat> getFirstAvailableSeatsByType(final SeatType type) {
        return seats.stream().filter(seat -> seat.getType() == type && seat.isNotReserved()).findFirst();
    }

    public List<Seat> getSeatsByType(final SeatType type) {
        return seats.stream().filter(seat -> seat.getType() == type).collect(Collectors.toList());
    }

    public int getNumberOfSeats() {
        return seats.size();
    }

}
