package com.solvd.zoo.animal;

public abstract class Mammal extends Animal {

    private int numberLegs;

    public int getNumberLegs() {
        return numberLegs;
    }

    public void setNumberLegs(int numberLegs) {
        this.numberLegs = numberLegs;
    }
}
