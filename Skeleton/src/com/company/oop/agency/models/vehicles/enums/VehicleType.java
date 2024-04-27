package com.company.oop.agency.models.vehicles.enums;

public enum VehicleType {
    LAND ("LAND"), AIR ("AIR"), SEA ("SEA");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
