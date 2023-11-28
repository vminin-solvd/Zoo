package zoo;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoo.animal.Animal;
import zoo.exceptions.InvalidNameException;
import zoo.exceptions.LocationException;
import zoo.person.Person;
import zoo.person.Visitor;
import zoo.person.ZooKeeper;
import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);
    private String name;
    private List<Animal> animals = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();
    private List<String> locations = new ArrayList<>();
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

    public List<Visitor> getVisitors() {
        return this.visitors;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public List<String> getLocations() {
        return this.locations;
    }

    public void addLocation(String location) {
        locations.add(location);
    }

    public HashMap<String, ZooKeeper> getZookeepers() {
        return this.zookeepers;
    }

    public void addZooKeeper(ZooKeeper zookeeper) {
        zookeepers.put(zookeeper.getName(), zookeeper);
    }

    public void moveLocation(Person person, String location) throws LocationException {
        if (locations.contains(location)) {
            person.setLocation(location, this);
        } else {
            LOGGER.info("Location not valid");
        }
    }
}
