package org.restate.project.model;
/**
 * Defines a region
 */
public class Location extends BaseObject {
    private  Country country;
    private County county;
    private Estate estate;
    private Town town;

    public Location() {
    }

    public Location(String name,Country country, County county, Estate estate, Town town) {
        this.setName(name);
        this.country = country;
        this.county = county;
        this.estate = estate;
        this.town = town;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
