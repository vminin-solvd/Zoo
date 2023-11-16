package zoo.person;

import zoo.animal.Animal;

public final class ZooKeeper extends Person implements IShout, IComplain{

    private int employeeID;
    private int numFood;

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getNumFood() {
        return this.numFood;
    }

    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    public void feedAnimal(Animal animal) {
        if (numFood > 0 && getLocation().equals(animal.getLocation())) {
            numFood--;
            System.out.println(getName() + " feeds " + animal.getClass().getSimpleName());
            animal.makeSound();
        }
    }

    @Override
    public void shout() {
        System.out.println("I LOVE BEING A ZOOKEEPER");
    }

    @Override
    public void complain() {
        System.out.println("WHY IS THERE SO MUCH POO");
    }
}
