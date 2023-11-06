package zoo.animal;

public class BaldEagle extends Bird {

    @Override
    public void makeSound() {
        System.out.println("Eagle scream");
    }

    @Override
    public String toString() {
        return "Bald Eagle: nests can get up to 10 feet across and weigh up to 2000 pounds!";
    }
}
