package com.company.oop.agency.models.contracts;

public interface Ticket extends Printable, Identifiable{

    Journey getJourney();

    double calculatePrice();

    double getAdministrativeCosts();

}