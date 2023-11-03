package Zoo;

import java.util.List;
import java.util.ArrayList;

class Zoo {
    private String name;
    private List<Animal> animals = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();
    private List<String> locations = new ArrayList<>();
    private List<ZooKeeper> zookeepers = new ArrayList<>();
    // Setters and getters for Zoo
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public List<Animal> getAnimals() {
        return this.animals;
    }
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
    public List<Visitor> getVisitors() {
        return this.visitors;
    }
    public void addLocation(String location) {
        locations.add(location);
    }
    public List<String> getLocations() {
        return this.locations;
    }
    public void addZooKeeper(ZooKeeper zookeeper) {
        zookeepers.add(zookeeper);
    }
    public List<ZooKeeper> getZookeepers() {
        return this.zookeepers;
    }
    public boolean moveLocation(Person person, String location) {
        if(locations.contains(location)) {
            person.setLocation(location);
            return true;
        }
        return false;
    }
}

abstract class Animal {
    private String location;
    private String sex;
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return this.sex;
    }
    abstract void makeSound();
}

class Bird extends Animal {
    private boolean canFly;
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    public boolean getCanFly() {
        return this.canFly;
    }
    @Override
    void makeSound() {
        System.out.println("Bird chirp");
    }
}

class BaldEagle extends Bird {
    @Override
    void makeSound() {
        System.out.println("Eagle scream");
    }
    @Override
    public String toString() {
        return "Fun bald eagle fact: eagle nests can get up to 10 feet across and weigh up to 2000 pounds!";
    }
}

abstract class Mammal extends Animal {
    private int numberLegs;
    public void setNumberLegs(int numberLegs) {
        this.numberLegs = numberLegs;
    }
    public int getNumberLegs() {
        return this.numberLegs;
    }
}

class Tiger extends Mammal {
    @Override
    void makeSound() {
        System.out.println("Tiger roar");
    }
    @Override
    public String toString() {
        return "Fun tiger fact: When a male lion breeds with a female tiger they create a liger which is larger than either a tiger or lion. These are not found in nature, only in zoos.";
    }
}

abstract class Reptile extends Animal {
    private boolean isVenomous;
    public void setIsVenomous(boolean isVenomous) {
        this.isVenomous = isVenomous;
    }
    public boolean getIsVenomous() {
        return this.isVenomous;
    }
}

class Crocodile extends Reptile {
    public void Crocodile() {
        this.setIsVenomous(false);
        this.setLocation("Crocodile pool");
    }
    @Override
    void makeSound() {
        System.out.println("Crocodile growl");
    }
    @Override
    public String toString() {
        return "Fun crocodile fact: Crocodiles are capable of having virgin births through self-reproduction!";
    }
}

class Person {
    private String name;
    private String location;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
}

class Visitor extends Person {
    private Ticket ticket;
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public Ticket getTicket() {
        return this.ticket;
    }
    @Override
    public String toString() {
        return "Visitor name=" + this.getName() + ", location=" + this.getLocation() + ", ticketID=" +  ticket.getTicketID();
    }
}

class ZooKeeper extends Person {
    private int employeeID;
    private int numFood;

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public int getEmployeeID() {
        return this.employeeID;
    }
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }
    public int getNumFood() {
        return this.numFood;
    }

    public void feedAnimal(Animal animal) {
        if(numFood > 0 && getLocation().equals(animal.getLocation())) {
            numFood--;
            System.out.println(getName() + " feeds " + animal.getClass().getSimpleName());
            animal.makeSound();
        }
    }
}

class Ticket {
    private int ticketID;
    private float discount;
    private float cost;
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    public int getTicketID() {
        return this.ticketID;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    public float getDiscount() {
        return this.discount;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public float getCost() {
        return this.cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        myZoo.setName("Victor's Zoo");

        Tiger tiger = new Tiger();
        tiger.setSex("Male");
        myZoo.addAnimal(tiger);
        System.out.println(tiger);

        BaldEagle eagle = new BaldEagle();
        eagle.setSex("Female");
        eagle.setCanFly(true);
        myZoo.addAnimal(eagle);
        System.out.println(eagle);

        Crocodile croc = new Crocodile();
        croc.setSex("Male");
        croc.setIsVenomous(false);
        myZoo.addAnimal(croc);
        System.out.println(croc);


        Visitor visitor = new Visitor();
        visitor.setName("Victor");
        Ticket ticket = new Ticket();
        ticket.setTicketID(1);
        visitor.setTicket(ticket);
        myZoo.addVisitor(visitor);

        ZooKeeper zooKeeper = new ZooKeeper();
        zooKeeper.setName("Pieter");
        zooKeeper.setNumFood(5);
        myZoo.addZooKeeper(zooKeeper);

        System.out.println("Welcome to " + myZoo.getName());
        System.out.println("We have " + myZoo.getAnimals().size() + " animals.");

        myZoo.addLocation("Tiger's Den");
        visitor.setLocation("Tiger's Den");
        tiger.setLocation("Tiger's Den");
        zooKeeper.setLocation("Tiger's Den");

        zooKeeper.feedAnimal(tiger);
    }
}

