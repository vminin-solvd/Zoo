package com.solvd.zoo.animal;
import com.solvd.zoo.enums.ZooLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.Zoo;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.interfaces.IAttack;
import com.solvd.zoo.interfaces.IDance;
import com.solvd.zoo.interfaces.IPlay;

public class Tiger extends Mammal implements IPlay, IDance, IAttack {

    private static final Logger LOGGER = LogManager.getLogger(Tiger.class);

    static {
        LOGGER.info("Tiger object has been created");
    }

    static int tigerCount = 0;

    public Tiger(Zoo zoo) throws LocationException {
        this.setLocation(ZooLocation.TIGERCAGE, zoo);
        tigerCount++;
    }

    public final String species = "Panthera tigris tigris";

    public final void showSpecies() {
        LOGGER.info("Species: " + species);
    }

    @Override
    public void makeSound() {
        LOGGER.info("Tiger roar");
    }

    @Override
    public void play() {
        LOGGER.info("The tiger chases a liger around the enclosure.");
    }

    @Override
    public void dance() {
        LOGGER.info("The tiger does a cheeky little twirl");
    }

    @Override
    public void attack() {
        LOGGER.info("The tiger swipes at the liger");
    }

    @Override
    public String toString() {
        return "This tiger is currently recovering in its enclosure from an injury.";
    }
}
