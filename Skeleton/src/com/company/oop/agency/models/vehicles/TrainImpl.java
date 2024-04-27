package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends BaseVehicle implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String INVALID_CARTS_COUNT =
            String.format(" A train cannot have less than %d cart or more than %d carts.",
                    CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private static final String TRAIN_CAPACITY_NOT_VALID =
            String.format(CAPACITY_NOT_VALID, "train", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        ValidationHelper.validateValueInRange(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE, INVALID_CARTS_COUNT);
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    protected void validateCapacity(int capacity) {
        ValidationHelper.validateValueInRange(capacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, TRAIN_CAPACITY_NOT_VALID);
    }

    @Override
    protected void validatePrice(double price, String errorMessage) {
        super.validatePrice(price, String.format(INVALID_VEHICLE_PRICE, PRICE_MIN_VALUE, PRICE_MAX_VALUE));
    }

    @Override
    public String getAsString() {
        return """
                Train ----
                %s
                Carts amount: %d
                """.formatted(super.getAsString(), carts);
    }
}