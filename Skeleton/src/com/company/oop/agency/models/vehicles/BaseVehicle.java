package com.company.oop.agency.models.vehicles;


import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;


public abstract class BaseVehicle implements Vehicle {

    private static final double VEHICLE_MIN_PRICE = 0.1;
    private static final double VEHICLE_MAX_PRICE = 2.5;
    protected static final String INVALID_VEHICLE_PRICE =
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    protected static final String CAPACITY_NOT_VALID =
            "A %s cannot have less than %d passengers or more than %d passengers.";


    private final int id;
    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType vehicleType;

    protected BaseVehicle(int id, int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.vehicleType = vehicleType;
        this.id = id;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePrice(pricePerKilometer, String.format(INVALID_VEHICLE_PRICE, VEHICLE_MIN_PRICE, VEHICLE_MAX_PRICE));
        this.pricePerKilometer = pricePerKilometer;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validateCapacity(passengerCapacity);
    }

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public int getPassengerCapacity() {
        return 0;
    }

    @Override
    public double getPricePerKilometer() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getAsString() {
        return """
                Passenger capacity: %d
                Price per kilometer: %.2f
                Vehicle type: %s
                """.formatted(passengerCapacity, pricePerKilometer, vehicleType);
    }

    protected abstract void validateCapacity(int capacity);

    protected void validatePrice(double price, String errorMessage) {
        ValidationHelper.validateValueInRange(pricePerKilometer, VEHICLE_MIN_PRICE, VEHICLE_MAX_PRICE, errorMessage);
    }
}
