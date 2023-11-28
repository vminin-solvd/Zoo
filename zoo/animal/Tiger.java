package zoo.animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoo.Zoo;
import zoo.exceptions.LocationException;
import zoo.interfaces.IAttack;
import zoo.interfaces.IDance;
import zoo.interfaces.IPlay;

public class Tiger extends Mammal implements IPlay, IDance, IAttack {

    private static final Logger LOGGER = LogManager.getLogger(Tiger.class);

    static {
        LOGGER.info("Tiger object has been created");
    }

    static int tigerCount = 0;

    public Tiger(Zoo zoo) throws LocationException {
        this.setLocation("Tiger's Den", zoo);
        tigerCount++;
    }

    public final String species = "Panthera tigris";

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
