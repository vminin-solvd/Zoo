package com.solvd.zoo.animal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class Bird extends Animal {

    private static final Logger LOGGER = LogManager.getLogger(Bird.class);
    private boolean canFly;

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean getCanFly() {
        return this.canFly;
    }

    @Override
    public void makeSound() {
        LOGGER.info("Bird chirp");
    }
}
