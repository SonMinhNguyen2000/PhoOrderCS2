package org.cs2.phoorder.models;

/**
 * A class that represents a shipping address.
 * It contains the street, city, state, and additional shipping information.
 * @author Son Minh Nguyen(Simon Cao) - Tram Nguyen (Sarah Nguyen)
 * @version 5/01/2024
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String addShippingInfo;
    private String apt = "";

    /**
     * Constructor for Address
     * @param street - street of the address
     * @param city - city of the address
     * @param state - state of the address
     * @param addShippingInfo - additional shipping information
     */
    public Address(
            String street,
            String city,
            String state,
            String addShippingInfo
    ) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.addShippingInfo = addShippingInfo;
    }

    /**
     * Default constructor for Address
     */
    public Address() {
        this.street = "";
        this.city = "";
        this.state = "";
        this.addShippingInfo = "";
    }

    /**
     * Get the street of the address
     * @return street of the address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street of the address
     * @param street - street of the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the apt no of the address
     * @return apt no of the address
     */
    public String getApt() {
        return apt;
    }

    /**
     * Set the apt no of the address
     * @param apt - apt no of the address
     */
    public void setApt(String apt) {
        this.apt = apt;
    }

    /**
     * Get the city of the address
     * @return city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of the address
     * @param city - city of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state of the address
     * @return state of the address
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state of the address
     * @param state - state of the address
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the additional shipping information
     * @return additional shipping information
     */
    public String getAddShippingInfo() {
        return addShippingInfo;
    }

    /**
     * Set the additional shipping information
     * @param addShippingInfo - additional shipping information
     */
    public void setAddShippingInfo(String addShippingInfo) {
        this.addShippingInfo = addShippingInfo;
    }
}
