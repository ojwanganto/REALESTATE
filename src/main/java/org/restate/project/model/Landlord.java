package org.restate.project.model;

import java.util.Date;

/**
 * This class defines a set of information relating to a Landlord
 */
public class Landlord extends Person {

    public Landlord(){

    }

    public Landlord(String names,Date dob,String gender){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);

    }
}
