package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.utils.ParsingHelpers;

import java.util.List;

public abstract class CreateVehicleBaseCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private final AgencyRepository agencyRepository;
    private int passengerCapacity;
    private double pricePerKilometer;

    protected CreateVehicleBaseCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    protected AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    protected int getPassengerCapacity() {
        return passengerCapacity;
    }

    protected double getPricePerKilometer() {
        return pricePerKilometer;
    }

    protected void parseParameters(List<String> parameters) {
        pricePerKilometer = ParsingHelpers.tryParseDouble(parameters.get(1), "price");
        passengerCapacity = ParsingHelpers.tryParseInteger(parameters.get(0), "passenger capacity");
    }
}
