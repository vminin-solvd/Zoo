package zoo.animal;

public final class BaldEagle extends Bird implements IPlay, IDance, IAttack{

    @Override
    public void makeSound() {
        System.out.println("Eagle scream");
    }

    @Override
    public String toString() {
        return "This bald eagle is currently laying on its eggs in the nest.";
    }

    @Override
    public void play() {
        System.out.println("The bald eagle plays fetch with zookeeper");
    }

    @Override
    public void dance() {
        System.out.println("The bald eagle tap dances in its enclosure");
    }

    @Override
    public void attack() {
        System.out.println("The bald eagle claws at a crow in the enclosure");
    }
}