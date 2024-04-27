package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTrainCommand extends CreateVehicleBaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private int cartsCount;

    public CreateTrainCommand(AgencyRepository agencyRepository) {
        super(agencyRepository);
    }

    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Train createdTrain = getAgencyRepository().createTrain(getPassengerCapacity(), getPricePerKilometer(), cartsCount);

        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdTrain.getId());
    }

    @Override
    protected void parseParameters(List<String> parameters) {
        super.parseParameters(parameters);
        cartsCount = ParsingHelpers.tryParseInteger(parameters.get(2), "carts");
    }

}