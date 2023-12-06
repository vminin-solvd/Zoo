package com.solvd.zoo;

import com.solvd.zoo.interfaces.ICheckCondition;
import com.solvd.zoo.interfaces.ICompareAttributes;
import com.solvd.zoo.interfaces.IUpdateZooLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.animal.*;
import com.solvd.zoo.enums.*;
import com.solvd.zoo.exceptions.ExpiredTicketException;
import com.solvd.zoo.exceptions.FeedAnimalException;
import com.solvd.zoo.exceptions.InvalidNameException;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.linkedlist.CustomLinkedList;
import com.solvd.zoo.ticket.Ticket;
import com.solvd.zoo.person.Visitor;
import com.solvd.zoo.person.ZooKeeper;

import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

import static com.solvd.zoo.Zoo.welcomeVisitor;
import static com.solvd.zoo.wordcounter.CountUniqueWords.countUniqueWord;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        Supplier<Visitor> visitorSupplier = Visitor::new;
        Visitor visitor = visitorSupplier.get();
        Ticket ticket = new Ticket();
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger;
        BaldEagle eagle;
        Crocodile croc;

        try {
            countUniqueWord("FamousPhrases.txt");

            try (Scanner scanner = new Scanner(System.in)) {
                LOGGER.info("Enter the Zoo's name: ");
                String zooName = scanner.nextLine();
                myZoo.setName(zooName);

                LOGGER.info("Enter the current time (HH:mm): ");
                String currentTime = scanner.nextLine();
                ZooStatus currentStatus = ZooStatus.getStatusBasedOnTime(currentTime);
                LOGGER.info("Zoo Status: " + currentStatus + " - " + currentStatus.getDescription());
            }

            visitor.setName("Victor");
            ticket.setTicketID(1);
            ticket.setCost(10);
            ticket.setDate("12/06/2023");
            visitor.setTicket(ticket);
            myZoo.addVisitor(visitor);

            welcomeVisitor();

            myZoo.addLocation(ZooLocation.TIGERCAGE);
            myZoo.addLocation(ZooLocation.BIRDCAGE);
            myZoo.addLocation(ZooLocation.REPTILECAGE);

            tiger = new Tiger(myZoo);
            tiger.setSex(Sex.MALE);
            tiger.setName("Ninja");
            tiger.setDietType(DietType.CARNIVORE);
            myZoo.addAnimal(tiger);
            LOGGER.info(tiger);

            eagle = new BaldEagle(myZoo);
            eagle.setSex(Sex.FEMALE);
            eagle.setName("Phoenix");
            eagle.setDietType(DietType.CARNIVORE);
            eagle.setCanFly(true);
            myZoo.addAnimal(eagle);
            LOGGER.info(eagle);

            croc = new Crocodile(myZoo);
            croc.setSex(Sex.MALE);
            croc.setName("Dino");
            croc.setDietType(DietType.CARNIVORE);
            croc.setIsVenomous(false);
            myZoo.addAnimal(croc);
            LOGGER.info(croc);

            LOGGER.info("Tiger: " + Sex.MALE.getCommonName(tiger));
            LOGGER.info("Eagle: " + Sex.FEMALE.getFullDescription(eagle));

            Season currentSeason = Season.SUMMER;
            LOGGER.info("Current Season: " + currentSeason);
            LOGGER.info("Temperature: " + currentSeason.getTemperature());
            LOGGER.info("Suggested Activity: " + currentSeason.getSuggestedActivity());
            LOGGER.info("Season Description: " + currentSeason.getSeasonDescription());

            Month currentMonth = Month.DECEMBER;
            LOGGER.info("Current Month: " + currentMonth);
            LOGGER.info("Days in " + currentMonth + ": " + currentMonth.getDays(false));
            LOGGER.info("Season in " + currentMonth + ": " + currentMonth.getSeason());

            BiFunction<String, String, String> animalGreeting = (species, name) -> "Welcome to our zoo, " + species + " named " + name + "!";
            LOGGER.info(animalGreeting.apply("Tiger", "Ninja"));

            Function<Animal, String> animalDietDescription = (animal) -> animal.getName() + " has a " + (animal.getDietType().isStrict() ? "strict" : "flexible") + " diet.";
            LOGGER.info(animalDietDescription.apply(tiger));

            Predicate<Animal> isCarnivore = animal -> animal.getDietType() == DietType.CARNIVORE;
            LOGGER.info("Is the Eagle a carnivore? " + isCarnivore.test(eagle));

            Consumer<Animal> printAnimal = animal -> LOGGER.info("Animal toString Details: " + animal);
            printAnimal.accept(tiger);

            ICompareAttributes<Animal> nameComparator = (a, b) -> a.getName().compareTo(b.getName());
            int comparisonResult = nameComparator.compare(tiger, eagle);
            LOGGER.info("Name comparison between Tiger and Eagle: " + comparisonResult);

            ICheckCondition<Animal> strictDietChecker = animal -> animal.getDietType().isStrict();
            boolean isTigerDietStrict = strictDietChecker.check(tiger);
            LOGGER.info("Does Tiger have a strict diet? " + isTigerDietStrict);

            IUpdateZooLocation<Animal> locationUpdater = (animal, newLocation) -> {
                try {
                    animal.setLocation(newLocation, myZoo);
                } catch (LocationException e){
                    LOGGER.error("Location Exception occurred", e);
                }
            };
            locationUpdater.update(eagle, ZooLocation.TIGERCAGE);
            LOGGER.info("Eagle's new location: " + eagle.getLocation());

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

            visitor.setLocation(ZooLocation.TIGERCAGE, myZoo);
            tiger.setLocation(ZooLocation.TIGERCAGE, myZoo);
            zooKeeper.setLocation(ZooLocation.TIGERCAGE, myZoo);

            Class<?> tigerClass = tiger.getClass();
            Constructor<?> constructor = tigerClass.getDeclaredConstructor(Zoo.class);
            Object tigerObject = constructor.newInstance(myZoo);
            Tiger tigerInstance = (Tiger)  tigerObject;
            tigerInstance.makeSound();
            Field speciesField = tigerClass.getDeclaredField("species");
            speciesField.setAccessible(true);
            speciesField.set(tigerInstance, "Panthera tigris altaica");
            String newSpecies = (String) speciesField.get(tigerInstance);
            LOGGER.info("This is the new species field: {}", newSpecies);

            long maleCount = myZoo.getAnimals().stream().filter(animal -> animal.getSex() == Sex.MALE).count();
            LOGGER.info("Total number of males: " + maleCount);

            List<String> uppercaseNames = myZoo.getAnimals().stream().map(animal -> animal.getName()
                    .toUpperCase()).collect(Collectors.toList());
            LOGGER.info("Here are the animal names in uppercase");
            uppercaseNames.forEach(name -> LOGGER.info(name));

            ZooLocation locationToCheck = ZooLocation.BIRDCAGE;
            boolean locationExists = myZoo.getLocations().stream().anyMatch(location -> location == locationToCheck);
            LOGGER.info(locationToCheck + " exists?: " + locationExists);

            List<Animal> carnivores = myZoo.getAnimals().stream()
                .filter(animal -> animal.getDietType() == DietType.CARNIVORE)
                .collect(Collectors.toList());
            LOGGER.info("Carnivore Animals:");
            carnivores.forEach(animal -> LOGGER.info(animal.getName()));
            
            List<String> zookeeperNames = myZoo.getZookeepers().values().stream()
                .map(zookeeper -> zookeeper.getName())
                .collect(Collectors.toList());
            LOGGER.info("Zookeeper Names:");
            zookeeperNames.forEach(name -> LOGGER.info(name));

            Map<Sex, List<Animal>> animalsBySex = myZoo.getAnimals().stream()
                .collect(Collectors.groupingBy(animal -> animal.getSex()));
            animalsBySex.forEach((sex, animals) -> {
                LOGGER.info("Sex: " + sex);
                animals.forEach(animal -> LOGGER.info("- " + animal.getName()));
            });

            boolean allTicketsTenDollars = myZoo.getVisitors().stream()
                .allMatch(v -> v.getTicket().getCost() == 10);
            LOGGER.info("Are all visitor's tickets $10?: " + allTicketsTenDollars);

            tiger.showSpecies();
            zooKeeper.feedAnimal(tiger);
        } catch (IOException | NoSuchFieldException | InstantiationException | InvocationTargetException
                 | NoSuchMethodException | IllegalAccessException | InvalidNameException
                 | ExpiredTicketException | LocationException | FeedAnimalException e) {
            LOGGER.error("Exception occurred: ", e);
        }

        LOGGER.info("Welcome to " + myZoo.getName());
        LOGGER.info("We have " + myZoo.getAnimals().size() + " animals.");
    }
}
