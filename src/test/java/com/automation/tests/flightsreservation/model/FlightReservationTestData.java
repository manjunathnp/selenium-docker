package com.automation.tests.flightsreservation.model;

public record FlightReservationTestData(String firstName,
                                        String lastName,
                                        String email,
                                        String password,
                                        String street,
                                        String city,
                                        String state,
                                        String zip,
                                        String passengerCount) {
}
