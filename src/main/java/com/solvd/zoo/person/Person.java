package com.solvd.zoo.person;

import com.solvd.zoo.Zoo;
import com.solvd.zoo.enums.ZooLocation;
import com.solvd.zoo.exceptions.InvalidNameException;
import com.solvd.zoo.exceptions.LocationException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Person {

    private String name;
    private ZooLocation location;

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidNameException {
        Pattern pattern = Pattern.compile("[^a-zA-Z,.!?\'\\-]");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new InvalidNameException("Name can only contain alphabetical characters!");
        }
        this.name = name;
    }

    public void setLocation(ZooLocation location, Zoo zoo) throws LocationException {
        if (!(zoo.getLocations().contains(location))) {
            throw new LocationException("This location has not been added to the zoo");
        }
        this.location = location;
    }

    public ZooLocation getLocation() {
        return this.location;
    }
}
