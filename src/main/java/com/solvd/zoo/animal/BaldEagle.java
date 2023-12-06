package com.solvd.zoo.animal;

import com.solvd.zoo.enums.ZooLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.Zoo;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.interfaces.IAttack;
import com.solvd.zoo.interfaces.IDance;
import com.solvd.zoo.interfaces.IPlay;

public final class BaldEagle extends Bird implements IPlay, IDance, IAttack {

    private static final Logger LOGGER = LogManager.getLogger(BaldEagle.class);

    @Override
    public void makeSound() {
        LOGGER.info("Eagle scream");
    }

    public BaldEagle(Zoo zoo) throws LocationException {
        this.setLocation(ZooLocation.BIRDCAGE, zoo);
    }

    @Override
    public void play() {
        LOGGER.info("The bald eagle plays fetch with zookeeper");
    }

    @Override
    public void dance() {
        LOGGER.info("The bald eagle tap dances in its enclosure");
    }

    @Override
    public void attack() {
        LOGGER.info("The bald eagle claws at a crow in the enclosure");
    }

    @Override
    public String toString() {
        return "This bald eagle is currently laying on its eggs in the nest.";
    }
}
