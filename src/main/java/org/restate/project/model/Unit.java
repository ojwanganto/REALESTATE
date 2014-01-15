package org.restate.project.model;

/**
 * Defines properties of a single unit in a house
 */
public class Unit {

    private House house;
    private String description;

    public Unit() {
    }

    public Unit(House house, String description) {
        this.house = house;
        this.description = description;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
