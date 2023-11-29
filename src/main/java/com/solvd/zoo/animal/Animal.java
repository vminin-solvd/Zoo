package com.solvd.zoo.animal;

import com.solvd.zoo.Zoo;
import com.solvd.zoo.enums.Sex;
import com.solvd.zoo.exceptions.LocationException;

public abstract class Animal {

    private String location;
    private Sex sex;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location, Zoo zoo) throws LocationException {

        if (!(zoo.getLocations().contains(location))) {
            throw new LocationException("This location has not been added to the zoo");
        }
        this.location = location;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public abstract void makeSound();
}
