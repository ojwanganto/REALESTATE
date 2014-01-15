package org.restate.project.model;

/**
 * Defines information about an estate located in an area
 */
public class Estate extends BaseObject {
    private County county;
    private String description;

    public Estate() {
    }

    public Estate(String name,County county, String description) {
        this.setName(name);
        this.county = county;
        this.description = description;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
