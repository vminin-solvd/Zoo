package zoo.person;

import zoo.Zoo;
import zoo.exceptions.LocationException;
import zoo.exceptions.nameException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Person {

    private String name;
    private String location;

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws nameException {

        Pattern pattern = Pattern.compile("[^a-zA-Z,.!?\'\\-]");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new nameException("Name can only contain alphabetical characters!");
        }
        this.name = name;
    }

    public void setLocation(String location, Zoo zoo) throws LocationException {

        if (!(zoo.getLocations().contains(location))) {
            throw new LocationException("This location has not been added to the zoo");
        }
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}
