package org.restate.project.model;

import java.util.Date;

/**
 * Defines basic information about a person.
 */
public class Person extends BaseObject {

    private Date dob;
    private String gender;
    private String nationalIdNo;
    private Country nationality;
    private String phoneNumber;
    private String address;

    //default constructor
    public Person(){

    }


    public Person(String name,Date dob,String gender,String nationalIdNo,Country nationality,
                  String phoneNumber ){
        this.setName(name);
        this.dob = dob;
        this.gender = gender;
        this.nationalIdNo = nationalIdNo;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;

    }

    public Person(String names,Date dob,String gender){
        this.setName(names);
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
}
