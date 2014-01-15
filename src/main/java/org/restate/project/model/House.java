package org.restate.project.model;

/**
 * A class that contains information about a house/block in an estate
 */
public class House extends BaseObject {
    private String code;
    private String description;
    private Estate estate;
    private Landlord landlord;

    //default constructor
    public House(){

    }

    public House(String name,String code, String description, Estate estate,Landlord landlord){
        this.setName(name);
        this.code = code;
        this.description = description;
        this.estate = estate;
        this.landlord = landlord;

    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }
}
