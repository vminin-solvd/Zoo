package zoo.animal;

public final class Crocodile extends Reptile implements IPlay, IDance, IAttack{

    public Crocodile() {
        this.setIsVenomous(false);
        this.setLocation("Crocodile pool");
    }

    @Override
    public void makeSound() {
        System.out.println("Crocodile growl");
    }

    @Override
    public String toString() {
        return "The crocodile is currently laying in the water with its eyes just above the waterline.";
    }

    @Override
    public void play() {
        System.out.println("The crocodile bites and death rolls another crocodile.");
    }

    @Override
    public void dance() {
        System.out.println("The crocodile does a front flip into the pool");
    }

    @Override
    public void attack() {
        System.out.println("The crocodile attacks another crocodile");
    }
}
