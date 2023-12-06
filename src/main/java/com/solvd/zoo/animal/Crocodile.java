package com.solvd.zoo.animal;
import com.solvd.zoo.enums.ZooLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.Zoo;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.interfaces.IAttack;
import com.solvd.zoo.interfaces.IDance;
import com.solvd.zoo.interfaces.IPlay;

public final class Crocodile extends Reptile implements IPlay, IDance, IAttack {

    private static final Logger LOGGER = LogManager.getLogger(Crocodile.class);

    public Crocodile(Zoo zoo) throws LocationException {
        this.setIsVenomous(false);
        this.setLocation(ZooLocation.REPTILECAGE, zoo);
    }

    @Override
    public void makeSound() {
        LOGGER.info("Crocodile growl");
    }

    @Override
    public void play() {
        LOGGER.info("The crocodile bites and death rolls another crocodile.");
    }

    @Override
    public void dance() {
        LOGGER.info("The crocodile does a front flip into the pool");
    }

    @Override
    public void attack() {
        LOGGER.info("The crocodile attacks another crocodile");
    }

    @Override
    public String toString() {
        return "The crocodile is currently laying in the water with its eyes just above the waterline.";
    }
}
