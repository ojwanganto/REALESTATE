package org.restate.project.model;

import java.util.Date;

/**
 * This class defines a set of information relating to a Landlord
 */
public class Landlord extends Person {
    private String nationalIdNo;
    private Country nationality;
    private String phoneNumber;
    private String address;
    private Person personId;

    public Landlord(){

    }

    public Landlord(String names,Date dob,String gender){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);

    }

    @Override
    public String getName() {
        return this.getFirstName() + " "+ this.getMiddleName() + " "+ this.getLastName();
    }

    public String getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(String nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }
}
