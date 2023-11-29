package com.solvd.zoo.person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.animal.Animal;
import com.solvd.zoo.exceptions.FeedAnimalException;
import com.solvd.zoo.exceptions.SpeakingException;
import com.solvd.zoo.interfaces.IShout;

public final class ZooKeeper extends Person implements IShout {

    private static final Logger LOGGER = LogManager.getLogger(ZooKeeper.class);
    private int employeeID;
    private int numFood;

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getNumFood() {
        return this.numFood;
    }

    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    public void feedAnimal(Animal animal) throws FeedAnimalException {
        if (numFood > 0 && animal.getLocation().equals(animal.getLocation())) {
            numFood--;
            LOGGER.info("{} feeds {}", getName(), animal.getClass().getSimpleName());
            animal.makeSound();
        }
        else {
            throw new FeedAnimalException("There is not enough food to feed the animal");
        }
    }

    @Override
    public void shout(String shoutString) throws SpeakingException {
        if (shoutString == null) {
            throw new SpeakingException("String cannot be null");
        }
        LOGGER.info(shoutString);
    }
}
