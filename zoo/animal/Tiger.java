package zoo.animal;

public class Tiger extends Mammal {
    @Override
    public void makeSound() {
        System.out.println("Tiger roar");
    }

    @Override
    public String toString() {
        return "Fun tiger fact: When a male lion breeds with a female tiger, they create a liger, which is larger than either a tiger or lion. These are not found in nature, only in zoos.";
    }
}
