package com.solvd.zoo.enums;

import com.solvd.zoo.animal.Animal;


public enum Sex {
    MALE("he", "Mr."),
    FEMALE("she", "Ms.");

    private final String pronoun;
    private final String titlePrefix;

    Sex(String pronoun, String titlePrefix) {
        this.pronoun = pronoun;
        this.titlePrefix = titlePrefix;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getTitlePrefix() {
        return titlePrefix;
    }

    public String getCommonName(Animal animal) {
        return titlePrefix + " " + animal.getName();
    }

    public String getFullDescription(Animal animal) {
        return titlePrefix + " " + animal.getName() + " (" + pronoun + ")";
    }
}
