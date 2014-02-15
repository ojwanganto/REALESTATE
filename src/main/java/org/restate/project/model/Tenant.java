package org.restate.project.model;

import java.util.Date;

/**
 * TDefines a tenant
 */

public class Tenant extends Person {

    private String maritalStatus;
    private String occupation;

    private String nationalIdNo;
    private Country nationality;
    private String phoneNumber;
    private String address;
    private Person personId;

    //default constructor
    public Tenant(){

    }

    public Tenant(String names,Date dob,String gender){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);

    }

    public Tenant(String names,Date dob,String gender,String maritalStatus,String occupation){
        this.setName(names);
        this.setDob(dob);
        this.setGender(gender);
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
    }

    @Override
    public String getName() {
        return this.getFirstName() + " "+ this.getMiddleName() + " "+ this.getLastName();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
