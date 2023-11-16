package zoo.animal;

import zoo.Zoo;
import zoo.exceptions.LocationException;

public class Tiger extends Mammal implements IPlay, IDance, IAttack {

    static {
        System.out.println("Tiger object has been created");
    }

    static int tigerCount = 0;

    public Tiger(Zoo zoo) throws LocationException {
        this.setLocation("Tiger's Den", zoo);
        tigerCount++;
    }

    public final String species = "Panthera tigris";

    public final void showSpecies() {
        System.out.println("Species: " + species);
    }

    @Override
    public void makeSound() {
        System.out.println("Tiger roar");
    }

    @Override
    public String toString() {
        return "This tiger is currently recovering in its enclosure from an injury.";
    }

    @Override
    public void play() {
        System.out.println("The tiger chases a liger around the enclosure.");
    }

    @Override
    public void dance() {
        System.out.println("The tiger does a cheeky little twirl");
    }

    @Override
    public void attack() {
        System.out.println("The tiger swipes at the liger");
    }
}
