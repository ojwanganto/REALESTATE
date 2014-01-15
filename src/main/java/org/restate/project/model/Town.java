package org.restate.project.model;

/**
 * TODO:please provide a brief description for the class.
 */
public class Town extends BaseObject {
    private County county;

    public Town(){

    }

    public Town(String name,County county) {
        this.setName(name);
        this.county = county;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
