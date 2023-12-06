package com.solvd.zoo.animal;

import com.solvd.zoo.Zoo;
import com.solvd.zoo.enums.DietType;
import com.solvd.zoo.enums.Sex;
import com.solvd.zoo.enums.ZooLocation;
import com.solvd.zoo.exceptions.LocationException;

public abstract class Animal {

    private ZooLocation location;
    private Sex sex;
    private String name;
    private DietType dietType;

    public ZooLocation getLocation() {
        return location;
    }

    public void setLocation(ZooLocation location, Zoo zoo) throws LocationException {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public abstract void makeSound();
}
