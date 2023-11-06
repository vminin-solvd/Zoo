package zoo;

import zoo.animal.*;
import zoo.ticket.Ticket;
import zoo.person.Visitor;
import zoo.person.ZooKeeper;
import zoo.zoo.Zoo;

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
