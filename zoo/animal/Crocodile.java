package zoo.animal;

public class Crocodile extends Reptile {

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
        return "Fun crocodile fact: Crocodiles are capable of having virgin births through self-reproduction!";
    }
}
