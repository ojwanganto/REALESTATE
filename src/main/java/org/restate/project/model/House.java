package org.restate.project.model;

/**
 * A class that contains information about a house/block in an estate
 */
public class House extends BaseObject {

    private String description;
    private Estate estate;
    private Landlord landlord;
    private String plotNo;


    //default constructor
    public House(){

    }

    public House(String name,String description, Estate estate,Landlord landlord){
        this.setName(name);
        this.description = description;
        this.estate = estate;
        this.landlord = landlord;

    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
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
