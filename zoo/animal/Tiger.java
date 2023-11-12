package zoo.animal;

public class Tiger extends Mammal implements IPlay, IDance, IAttack {

    static {
        System.out.println("Tiger object has been created");
    }

    static int tigerCount = 0;

    public Tiger() {
        tigerCount++;
    }

    public static void staticMethod() {
        System.out.println("This static method can be called with no tiger object created");
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
