package com.solvd.zoo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.animal.*;
import com.solvd.zoo.enums.Sex;
import com.solvd.zoo.exceptions.ExpiredTicketException;
import com.solvd.zoo.exceptions.FeedAnimalException;
import com.solvd.zoo.exceptions.InvalidNameException;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.linkedlist.CustomLinkedList;
import com.solvd.zoo.ticket.Ticket;
import com.solvd.zoo.person.Visitor;
import com.solvd.zoo.person.ZooKeeper;
import java.io.IOException;
import java.util.Scanner;
import static com.solvd.zoo.Zoo.welcomeVisitor;
import static com.solvd.zoo.wordcounter.CountUniqueWords.countUniqueWord;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        Visitor visitor = new Visitor();
        Ticket ticket = new Ticket();
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = null;
        BaldEagle eagle = null;
        Crocodile croc = null;

        try {
            countUniqueWord("FamousPhrases.txt");

            try (Scanner scanner = new Scanner(System.in)) {
                LOGGER.info("Enter the Zoo's name: ");
                String zooName = scanner.nextLine();
                myZoo.setName(zooName);
            }

            visitor.setName("Victor");
            ticket.setTicketID(1);
            ticket.setCost(10);
            ticket.setDate("11/17/2023");
            visitor.setTicket(ticket);
            myZoo.addVisitor(visitor);

            welcomeVisitor();

            myZoo.addLocation("Tiger's Den");
            myZoo.addLocation("Eagle's cage");
            myZoo.addLocation("Crocodile pool");

            tiger = new Tiger(myZoo);
            tiger.setSex(Sex.MALE);
            myZoo.addAnimal(tiger);
            LOGGER.info(tiger);

            eagle = new BaldEagle(myZoo);
            eagle.setSex(Sex.FEMALE);
            eagle.setCanFly(true);
            myZoo.addAnimal(eagle);
            LOGGER.info(eagle);

            croc = new Crocodile(myZoo);
            croc.setSex(Sex.MALE);
            croc.setIsVenomous(false);
            myZoo.addAnimal(croc);
            LOGGER.info(croc);

            CustomLinkedList linkedList = new CustomLinkedList();
            linkedList.add(tiger);
            linkedList.add(croc);
            linkedList.add(eagle);
            linkedList.get(1);
            linkedList.remove(tiger);
            linkedList.remove(croc);
            linkedList.remove(eagle);

            zooKeeper.setName("Pieter");
            zooKeeper.setNumFood(0);
            myZoo.addZooKeeper(zooKeeper);

            visitor.setLocation("Tiger's Den", myZoo);
            tiger.setLocation("Tiger's Den", myZoo);
            zooKeeper.setLocation("Tiger's Den", myZoo);

            tiger.showSpecies();
            zooKeeper.feedAnimal(tiger);

        } catch (IOException | InvalidNameException | ExpiredTicketException | LocationException | FeedAnimalException e) {
            LOGGER.error("Exception occurred: ", e);
        }

        LOGGER.info("Welcome to " + myZoo.getName());
        LOGGER.info("We have " + myZoo.getAnimals().size() + " animals.");
    }
}
