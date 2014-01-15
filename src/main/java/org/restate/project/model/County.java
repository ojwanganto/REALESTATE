package org.restate.project.model;

/**
 * TODO:please provide a brief description for the class.
 */
public class County extends BaseObject {
    private String code;
    private Country country;

    public County() {
    }

    public County(String name,String code, Country country) {
        this.setName(name);
        this.code = code;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
