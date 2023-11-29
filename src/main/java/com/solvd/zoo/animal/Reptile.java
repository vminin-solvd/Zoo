package com.solvd.zoo.animal;

public abstract class Reptile extends Animal {

    private boolean isVenomous;

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setIsVenomous(boolean isVenomous) {
        this.isVenomous = isVenomous;
    }
}
