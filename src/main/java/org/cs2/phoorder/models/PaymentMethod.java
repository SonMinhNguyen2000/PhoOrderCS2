package org.cs2.phoorder.models;

public class PaymentMethod {
    private String cardNumber;
    private String cardName;
    private String expirationDate;
    private String cvv;
    private String billingAddress;

    public PaymentMethod() {
        this.cardNumber = "";
        this.cardName = "";
        this.expirationDate = "";
        this.cvv = "";
        this.billingAddress = "";
    }

    public String toString() {
        return "Card Number: " + cardNumber + "\nCard Name: " + cardName + "\nExpiration Date: " + expirationDate + "\nCVV: " + cvv + "\nBillingAddress: " + billingAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
