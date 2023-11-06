package zoo.animal;

public class Bird extends Animal {

    private boolean canFly;

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean getCanFly() {
        return this.canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Bird chirp");
    }
}
