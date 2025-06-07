package com.kipcollo.controller.model;

import java.io.Serializable;

public class Contact implements Serializable{
    private int contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // No argument constructor
    public Contact(){
        
    }
    //All arguments constructor
    public Contact(int contactID,String firstName,String lastName,String phoneNumber){
        this.contactID=contactID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
    }
    // Getters and setters
    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
