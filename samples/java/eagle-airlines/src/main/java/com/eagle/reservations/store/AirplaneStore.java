package com.eagle.reservations.store;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.eagle.reservations.model.Airplane;

public enum AirplaneStore {
    INSTANCE;

    private final Map<Long, Airplane> airplanes = new ConcurrentHashMap<>();

    public static AirplaneStore getInstance() {
        return INSTANCE;
    }

    public synchronized void add(Airplane airplane) {
        getInstance().airplanes.put(airplane.getId(), airplane);
    }

    public synchronized void remove(Airplane airplane) {
        getInstance().airplanes.remove(airplane.getId());
    }

    public void clear() {
        getInstance().airplanes.clear();
    }

    public Optional<Airplane> fetch(long id) {
        return Optional.ofNullable(getInstance().airplanes.get(id));
    }

    public Collection<Airplane> getAll() {
        return getInstance().airplanes.values();
    }

}
