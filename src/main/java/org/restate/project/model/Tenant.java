package org.restate.project.model;

import java.util.Date;

/**
 * TDefines a tenant
 */
public class Tenant extends Person {

    private String maritalStatus;
    private Occupation occupation;

    //default constructor
    public Tenant(){

    }

    public Tenant(String names,Date dob,String gender){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);

    }

    public Tenant(String names,Date dob,String gender,String maritalStatus,Occupation occupation){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        occupation = occupation;
    }
}
