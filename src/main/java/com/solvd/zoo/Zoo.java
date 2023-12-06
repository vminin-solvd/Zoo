package com.solvd.zoo;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.solvd.zoo.enums.ZooLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.animal.Animal;
import com.solvd.zoo.exceptions.InvalidNameException;
import com.solvd.zoo.exceptions.LocationException;
import com.solvd.zoo.exceptions.SpeakingException;
import com.solvd.zoo.person.Person;
import com.solvd.zoo.person.Visitor;
import com.solvd.zoo.person.ZooKeeper;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);
    private String name;

    private List<Animal> animals = new ArrayList<>();
    private Queue<Visitor> visitors = new LinkedList<>();
    private Map<Integer, Visitor> complainers = new TreeMap<>();
    private Set<ZooLocation> locations = new HashSet<>();
    private HashMap<String, ZooKeeper> zookeepers = new HashMap<>();

    public static void welcomeVisitor() {
        LOGGER.info("Enjoy your visit today at the Zoo!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidNameException {
        Pattern pattern = Pattern.compile("[^a-zA-Z,.!?\'\\- ]");
        Matcher matcher = pattern.matcher(name);
        if ((matcher.find())) {
            throw new InvalidNameException("Name can only contain alphabetical characters!");
        }
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Queue<Visitor> getVisitors() {
        return this.visitors;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public Map<Integer, Visitor> getComplainers() {
        return complainers;
    }

    public Set<ZooLocation> getLocations() {
        return this.locations;
    }

    public void addLocation(ZooLocation location) {
        locations.add(location);
    }

    public HashMap<String, ZooKeeper> getZookeepers() {
        return this.zookeepers;
    }

    public void addZooKeeper(ZooKeeper zookeeper) {
        zookeepers.put(zookeeper.getName(), zookeeper);
    }


    public Visitor processNextVisitor() {
        return visitors.poll();
    }

    public void moveLocation(Person person, ZooLocation location) throws LocationException {
        if (locations.contains(location)) {
            person.setLocation(location, this);
        } else {
            LOGGER.info("Location not valid");
        }
    }

    public void handleComplaint(Visitor visitor, String complainString) throws SpeakingException {
        if (complainString == null) {
            throw new SpeakingException("complainString cannot be empty");
        }
        complainers.put(visitor.getTicket().getTicketID(), visitor);
        LOGGER.info(complainString);
    }
}
