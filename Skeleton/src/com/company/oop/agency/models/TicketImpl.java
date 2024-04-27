package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    private static final String VALUE_MUST_BE_POSITIVE = "Value of '%s' must be a positive number. Actual value: %.2f.";
    private final int id;
    private double administrativeCosts;
    private final Journey journey;


    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setAdministrativeCosts(costs);
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts < 0) {
            throw new InvalidUserInputException(String.format(VALUE_MUST_BE_POSITIVE, "costs", administrativeCosts));
        }

        this.administrativeCosts = administrativeCosts;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts() * administrativeCosts;
    }

    @Override
    public String getAsString() {
        return """
                Ticket ----
                Destination: %s
                Price: %.2f
                """.formatted(journey.getDestination(), calculatePrice());
    }
}
