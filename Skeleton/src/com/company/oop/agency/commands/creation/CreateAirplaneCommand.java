package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateAirplaneCommand extends CreateVehicleBaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private boolean hasFreeFood;

    public CreateAirplaneCommand(AgencyRepository agencyRepository) {
        super(agencyRepository);
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Airplane createdAirplane = getAgencyRepository().createAirplane(getPassengerCapacity(), getPricePerKilometer(), hasFreeFood);

        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdAirplane.getId());
    }

    @Override
    protected void parseParameters(List<String> parameters) {
        super.parseParameters(parameters);
        hasFreeFood = ParsingHelpers.tryParseBoolean(parameters.get(2), "has free food");
    }
}