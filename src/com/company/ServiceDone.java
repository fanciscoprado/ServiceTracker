package com.company;

import java.io.Serializable;

public class ServiceDone implements Serializable {
    private int miles;
    private boolean oil, airFilter, fuelFilter, cabinAir, breakPads = false;

    public ServiceDone(int miles, boolean oil, boolean airFilter, boolean fuelFilter, boolean cabinAir, boolean breakPads) {
        this.miles = miles;
        this.oil = oil;
        this.airFilter = airFilter;
        this.fuelFilter = fuelFilter;
        this.cabinAir = cabinAir;
        this.breakPads = breakPads;
    }

    public int getMiles() {
        return miles;
    }

    public boolean isOil() {
        return oil;
    }

    public boolean isAirFilter() {
        return airFilter;
    }

    public boolean isFuelFilter() {
        return fuelFilter;
    }

    public boolean isCabinAir() {
        return cabinAir;
    }

    public boolean isBreakPads() {
        return breakPads;
    }
}
