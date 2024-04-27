package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateBusCommand extends CreateVehicleBaseCommand {


    public CreateBusCommand(AgencyRepository agencyRepository) {
        super(agencyRepository);
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Bus createdBus = getAgencyRepository().createBus(getPassengerCapacity(), getPricePerKilometer());

        return String.format(CommandsConstants.VEHICLE_CREATED_MESSAGE, createdBus.getId());
    }

}