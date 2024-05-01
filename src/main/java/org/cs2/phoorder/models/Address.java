package org.cs2.phoorder.models;

public class Address {
    private String street;
    private String city;
    private String state;
    private String addShippingInfo;
    private String apt = "";

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

    public Address() {
        this.street = "";
        this.city = "";
        this.state = "";
        this.addShippingInfo = "";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddShippingInfo() {
        return addShippingInfo;
    }

    public void setAddShippingInfo(String addShippingInfo) {
        this.addShippingInfo = addShippingInfo;
    }
}
