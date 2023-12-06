package com.solvd.zoo.enums;

public enum DietType {
    CARNIVORE(true),
    OMNIVORE(false),
    HERBIVORE(true);

    private final boolean isStrict;

    DietType(boolean isStrict) {
        this.isStrict = isStrict;
    }

    public boolean isStrict() {
        return isStrict;
    }

    public boolean isFoodCompatible(String food) {
        if (this == CARNIVORE && food.equalsIgnoreCase("meat")) {
            return true;
        } else if (this == OMNIVORE) {
            return true; // Omnivores can eat pretty much anything
        } else if (this == HERBIVORE && !food.equalsIgnoreCase("meat")) {
            return true;
        }
        return false;
    }
}