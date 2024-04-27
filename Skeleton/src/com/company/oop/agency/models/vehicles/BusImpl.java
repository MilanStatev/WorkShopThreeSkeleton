package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends BaseVehicle implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String BUS_CAPACITY_NOT_VALID =
            String.format(CAPACITY_NOT_VALID, "A bus", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final double BUS_PRICE_MIN_VALUE = 0.1;
    private static final double BUS_PRICE_MAX_VALUE = 2.5;
    private static final String BUS_PRICE_ERROR_MESSAGE =
            String.format(INVALID_VEHICLE_PRICE, BUS_PRICE_MIN_VALUE, BUS_PRICE_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
    }

    @Override
    protected void validateCapacity(int capacity) {
        ValidationHelper.validateValueInRange(capacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, BUS_CAPACITY_NOT_VALID);
    }

    @Override
    protected void validatePrice(double price, String errorMessage) {
        super.validatePrice(price, errorMessage);
        ValidationHelper.validateValueInRange(price, BUS_PRICE_MIN_VALUE, BUS_PRICE_MAX_VALUE, BUS_PRICE_ERROR_MESSAGE);
    }

    @Override
    public String getAsString() {
        return """
                Bus ----
                %s
                """.formatted(super.getAsString());
    }
}