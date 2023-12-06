package com.solvd.zoo.enums;

import static com.solvd.zoo.enums.Food.*;

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

    public boolean isFoodCompatible(Food food) {
        return (this == CARNIVORE && food == MEAT) || (this == OMNIVORE) || (this == HERBIVORE && (food == VEGETABLES || food == FRUITS));
    }
}