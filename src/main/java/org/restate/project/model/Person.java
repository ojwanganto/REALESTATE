package org.restate.project.model;

import java.util.Date;

/**
 * Defines basic information about a person.
 */
public class Person extends BaseObject {

    private Date dob = new Date();
    private String gender;
    private String firstName;
    private String middleName;
    private String lastName;

    //default constructor
    public Person(){
    }

    public Person(String name,Date dob,String gender){
        this.setName(name);
        this.dob = dob;
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
