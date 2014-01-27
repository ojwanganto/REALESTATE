package org.restate.project.model;

/**
 * Defines information about an estate located in an area
 */
public class Estate extends BaseObject {
    private Town town;
    private String description;

    public Estate() {
    }

    public Estate(String name,Town town, String description) {
        this.setName(name);
        this.town = town;
        this.description = description;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
