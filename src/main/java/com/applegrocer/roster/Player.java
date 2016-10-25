package com.applegrocer.roster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AppleGrocer
 */
public class Player {

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private Integer zip;
    private String fullAddress;

    public Player(String fName, String lName, String street, String city,
            String state, Integer zip) {
        this.firstName = fName;
        this.lastName = lName;
        this.streetAddress = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        setFullAddress();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullAddress();
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullAddress();
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        setFullAddress();
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
        setFullAddress();
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
        setFullAddress();
    }

    /**
     * @return the zip
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(Integer zip) {
        this.zip = zip;
        setFullAddress();
    }

    public String getFullAddress() {
        return this.fullAddress;
    }

    private void setFullAddress() {
        this.fullAddress = this.streetAddress + ", " + city + ", " + state
                + " " + zip;
    }
}
