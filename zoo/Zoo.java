package zoo;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import zoo.animal.Animal;
import zoo.exceptions.LocationException;
import zoo.exceptions.nameException;
import zoo.person.Person;
import zoo.person.Visitor;
import zoo.person.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private String name;
    private List<Animal> animals = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();
    private List<String> locations = new ArrayList<>();
    private List<ZooKeeper> zookeepers = new ArrayList<>();

    public static void welcomeVisitor() {
        System.out.println("Enjoy your visit today at the Zoo!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws nameException {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        Matcher matcher = pattern.matcher(name);
        if((matcher.find())) {
            throw new nameException("Name can only contain alphabetical characters!");
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

    public List<ZooKeeper> getZookeepers() {
        return this.zookeepers;
    }

    public void addZooKeeper(ZooKeeper zookeeper) {
        zookeepers.add(zookeeper);
    }

    public void moveLocation(Person person, String location) throws LocationException {
        if (locations.contains(location)) {
            person.setLocation(location, this);
        }
        else {
            System.out.println("Location not valid");
        }

    }
}
