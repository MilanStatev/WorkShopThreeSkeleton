package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    private static final int START_LOCATION_MIN_LENGTH = 5;
    private static final int START_LOCATION_MAX_LENGTH = 25;
    private static final int DESTINATION_MIN_LENGTH = 5;
    private static final int DESTINATION_MAX_LENGTH = 25;
    private static final String LENGTH_NOT_VALID = "The %s length cannot be less than %d or more than %d symbols long.";
    private static final int DISTANCE_MIN_VALUE = 5;
    private static final int DISTANCE_MAX_VALUE = 5000;
    private static final String DISTANCE_NOT_VALID = "The %s cannot be less than %d or more than %d kilometers.";

    private final int id;
    private String startLocation;
    private String destination;
    private int distance;
    private final Vehicle vehicle;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        this.id = id;
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;

    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation,
                START_LOCATION_MIN_LENGTH,
                START_LOCATION_MAX_LENGTH,
                String.format(LENGTH_NOT_VALID, "StartingLocation's", START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH));
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination,
                DESTINATION_MIN_LENGTH,
                DESTINATION_MAX_LENGTH,
                String.format(LENGTH_NOT_VALID, "Destination's", DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH));
        this.destination = destination;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE,
                String.format(DISTANCE_NOT_VALID, "Distance", DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE));

        this.distance = distance;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public String getAsString() {
        return """
                Journey ----
                Start location: %s
                Destination: %s
                Distance: %d
                Vehicle type: %s
                Travel costs: %.2f
                """.formatted(startLocation, destination, distance, vehicle.getType(), calculateTravelCosts());
    }
}