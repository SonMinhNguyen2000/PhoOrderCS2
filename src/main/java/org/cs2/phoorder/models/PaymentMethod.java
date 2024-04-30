package org.cs2.phoorder.models;

public class PaymentMethod {
    private String cardNumber;
    private String cardName;
    private String expirationDate;
    private String cvv;
    private String zip;

    public PaymentMethod() {
        this.cardNumber = "";
        this.cardName = "";
        this.expirationDate = "";
        this.cvv = "";
        this.zip = "";
    }

    public String toString() {
        return "Card Number: " + cardNumber + "\nCard Name: " + cardName + "\nExpiration Date: " + expirationDate + "\nCVV: " + cvv + "\nZip: " + zip;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
