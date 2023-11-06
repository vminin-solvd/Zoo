package zoo.person;

import zoo.animal.Animal;

public class ZooKeeper extends Person {

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
}
