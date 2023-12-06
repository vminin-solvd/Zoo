package com.solvd.zoo.enums;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public enum ZooStatus {
    OPEN("The zoo is open to visitors."),
    CLOSED("The zoo is currently closed to visitors.");

    private final String description;

    private static final LocalTime OPENING_TIME = LocalTime.of(9, 0);
    private static final LocalTime CLOSING_TIME = LocalTime.of(18, 0);

    ZooStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ZooStatus getStatusBasedOnTime(String userInputTime) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime userTime;
        try {
            userTime = LocalTime.parse(userInputTime, timeFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Time entered is not valid. Please use the HH:mm format.");
        }
        return (userTime.isBefore(OPENING_TIME) || userTime.isAfter(CLOSING_TIME)) ? CLOSED : OPEN;
    }
}
