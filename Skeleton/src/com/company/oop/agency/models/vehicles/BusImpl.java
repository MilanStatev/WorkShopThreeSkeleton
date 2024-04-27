package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends BaseVehicle implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String BUS_CAPACITY_NOT_VALID =
            String.format(CAPACITY_NOT_VALID, "bus", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
    }

    @Override
    protected void validateCapacity(int capacity) {
        ValidationHelper.validateValueInRange(capacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, BUS_CAPACITY_NOT_VALID);
    }

    @Override
    public String getAsString() {
        return """
                Bus ----
                %s
                """.formatted(super.getAsString());
    }
}