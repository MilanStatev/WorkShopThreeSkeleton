package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public class AirplaneImpl extends BaseVehicle implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    private static final String AIRPLANE_CAPACITY_NOT_VALID =
            String.format(CAPACITY_NOT_VALID, "An airplane", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final double AIRPLANE_PRICE_MIN_VALUE = 0.1;
    public static final double AIRPLANE_PRICE_MAX_VALUE = 2.5;
    private static final String AIRPLANE_PRICE_ERROR_MESSAGE =
            String.format(INVALID_VEHICLE_PRICE, AIRPLANE_PRICE_MIN_VALUE, AIRPLANE_PRICE_MAX_VALUE);

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    protected void validateCapacity(int capacity) {
        ValidationHelper.validateValueInRange(capacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, AIRPLANE_CAPACITY_NOT_VALID);
    }

    @Override
    protected void validatePrice(double price, String errorMessage) {
        super.validatePrice(price, errorMessage);
        ValidationHelper.validateValueInRange(price, AIRPLANE_PRICE_MIN_VALUE, AIRPLANE_PRICE_MAX_VALUE, AIRPLANE_PRICE_ERROR_MESSAGE);
    }

    @Override
    public String getAsString() {
        return """
                Airplane ----
                %s
                Has free food: %s
                """.formatted(super.getAsString(), hasFreeFood);
    }
}