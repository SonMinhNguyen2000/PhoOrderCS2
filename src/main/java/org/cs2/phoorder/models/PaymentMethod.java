package org.cs2.phoorder.models;

/**
 * A class that represents a payment method.
 */
public class PaymentMethod {
    private String cardNumber;
    private String cardName;
    private String expirationDate;
    private String cvv;
    private String billingAddress;

    /**
     * Constructor for PaymentMethod
     */
    public PaymentMethod() {
        this.cardNumber = "";
        this.cardName = "";
        this.expirationDate = "";
        this.cvv = "";
        this.billingAddress = "";
    }

    /**
     * print out the payment info
     * @return a string representing the payment info
     */
    @Override
    public String toString() {
        return "Card Number: " + cardNumber + "\nCard Name: " + cardName + "\nExpiration Date: " + expirationDate + "\nCVV: " + cvv + "\nBillingAddress: " + billingAddress;
    }

    /**
     * Get the card number
     * @return card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Set the card number
     * @param cardNumber - card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Get the card name
     * @return card name
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Set the card name
     * @param cardName - card name
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Get the expiration date
     * @return expiration date
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Set the expiration date
     * @param expirationDate - expiration date
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Get the cvv
     * @return cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Set the cvv
     * @param cvv - cvv
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Get the billing address
     * @return billing address
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * Set the billing address
     * @param billingAddress - billing address
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
