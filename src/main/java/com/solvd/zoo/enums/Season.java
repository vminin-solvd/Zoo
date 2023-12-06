package com.solvd.zoo.enums;

public enum Season {
    WINTER("cold", "Indoor viewing"),
    SPRING("mild", "Newborn animals"),
    SUMMER("hot", "Evening shows"),
    FALL("cool", "Leaves changing around the zoo");

    private final String temperature;
    private final String suggestedActivity;

    Season(String temperature, String suggestedActivity) {
        this.temperature = temperature;
        this.suggestedActivity = suggestedActivity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getSuggestedActivity() {
        return suggestedActivity;
    }

    public String getSeasonDescription() {
        return "During " + this.name().toLowerCase() +
                ", the temperature is typically " + temperature + ". " + suggestedActivity + " is recommended.";
    }
}
