package org.restate.project.model;

/**
 * TODO:please provide a brief description for the class.
 */
public class Country extends BaseObject {
    private String code;

    public Country() {
    }

    public Country(String name) {
        this.setName(name);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
