package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class AirplaneImpl extends BaseVehicle implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id,passengerCapacity, pricePerKilometer, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public String getAsString() {
        return """
                Airplane ----
                %s
                Has free food: %s
                """.formatted(super.getAsString(), hasFreeFood);
    }

    @Override
    protected void validateCapacity(int capacity) {

    }

    @Override
    public boolean hasFreeFood() {
        return false;
    }
}