package zoo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoo.animal.*;
import zoo.exceptions.ExpiredTicketException;
import zoo.exceptions.FeedAnimalException;
import zoo.exceptions.LocationException;
import zoo.exceptions.nameException;
import zoo.ticket.Ticket;
import zoo.person.Visitor;
import zoo.person.ZooKeeper;

import java.util.Scanner;

import static zoo.Zoo.welcomeVisitor;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws nameException, LocationException, ExpiredTicketException, FeedAnimalException {

        LOGGER.info("DEBUG");

        Zoo myZoo = new Zoo();

        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Enter the Zoo's name: ");
            String zooName = scanner.nextLine();
            myZoo.setName(zooName);
        } catch (nameException e) {
            LOGGER.error("Name exception occurred: " + e.getMessage());
            }


        Visitor visitor = new Visitor();
        try {
            visitor.setName("Victor");
        } catch (nameException e) {
            LOGGER.error("Name exception occurred: " + e.getMessage());
        }

        Ticket ticket = new Ticket();
        ticket.setTicketID(1);
        ticket.setCost(10);

        try {
            ticket.setDate(11, 17, 2023);
        } catch (ExpiredTicketException e) {
            LOGGER.error("ExpiredTicketException occurred: " + e.getMessage());
        }

        visitor.setTicket(ticket);
        myZoo.addVisitor(visitor);

        welcomeVisitor();

        myZoo.addLocation("Tiger's Den");
        myZoo.addLocation("Eagle's cage");
        myZoo.addLocation("Crocodile pool");

        Tiger tiger = new Tiger(myZoo);
        tiger.setSex(Sex.MALE);
        myZoo.addAnimal(tiger);
        System.out.println(tiger);

        BaldEagle eagle = new BaldEagle(myZoo);
        eagle.setSex(Sex.FEMALE);
        eagle.setCanFly(true);
        myZoo.addAnimal(eagle);
        System.out.println(eagle);

        Crocodile croc = new Crocodile(myZoo);
        croc.setSex(Sex.MALE);
        croc.setIsVenomous(false);
        myZoo.addAnimal(croc);
        System.out.println(croc);

        ZooKeeper zooKeeper = new ZooKeeper();
        try {
            zooKeeper.setName("Pieter");
        } catch (nameException e) {
            LOGGER.error("NameException occurred: " + e.getMessage());
        }

        zooKeeper.setNumFood(0);
        myZoo.addZooKeeper(zooKeeper);

        try {
            visitor.setLocation("Tiger's Den", myZoo);
            tiger.setLocation("Tiger's Den", myZoo);
            zooKeeper.setLocation("Tiger's Den", myZoo);
        } catch (LocationException e) {
            LOGGER.error("LocationException occurred: " + e.getMessage());
        }

        System.out.println("Welcome to " + myZoo.getName());
        System.out.println("We have " + myZoo.getAnimals().size() + " animals.");

        tiger.showSpecies();
        try {
            zooKeeper.feedAnimal(tiger);
        } catch (FeedAnimalException e) {

            LOGGER.error("FeedAnimalException occurred: " + e.getMessage());
        }

    }
}
