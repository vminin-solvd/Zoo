package zoo.animal;

public class Tiger extends Mammal implements IPlay, IDance, IAttack {

    @Override
    public void makeSound() {
        System.out.println("Tiger roar");
    }

    @Override
    public String toString() {
        return "This tiger is currently recovering in its enclosure from an injuer.";
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
