package zoo.animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoo.Zoo;
import zoo.exceptions.LocationException;

public final class Crocodile extends Reptile implements IPlay, IDance, IAttack {

    private static final Logger LOGGER = LogManager.getLogger(Crocodile.class);

    public Crocodile(Zoo zoo) throws LocationException {

        this.setIsVenomous(false);
        this.setLocation("Crocodile pool", zoo);
    }

    @Override
    public void makeSound() {
        LOGGER.info("Crocodile growl");
    }

    @Override
    public String toString() {
        return "The crocodile is currently laying in the water with its eyes just above the waterline.";
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
}
