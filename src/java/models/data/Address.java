package models.data;

import java.io.Serializable;

public class Address implements Serializable{
    private int addressID;
    private String streetAddress;
    private String apartmentNumber;
    private String city;
    private String zipCode;
    private String additionalNotes;

    // No arguments constructor
    public Address(){
        
    }
    
    //All args constructor
    public Address(int addressID,String streetAddress,String apartmentNumber,String city,String zipCode,String additionalNotes){
        this.addressID=addressID;
        this.streetAddress=streetAddress;
        this.apartmentNumber=apartmentNumber;
        this.city=city;
        this.zipCode=zipCode;
        this.additionalNotes=additionalNotes;
    }
    

    // getters and setters
    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}

