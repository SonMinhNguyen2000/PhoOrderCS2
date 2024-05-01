package org.cs2.phoorder.models;

/**
 * A class that represents a customer.
 * @author Son Minh Nguyen(Simon Cao) - Tram Nguyen (Sarah Nguyen)
 * @version 5/01/2024
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private PaymentMethod paymentMethod;

    /**
     * Constructor for Customer
     */
    public Customer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phone = "";
        this.address = new Address();
        this.paymentMethod = new PaymentMethod();
    }

    /**
     * Get the first name of the customer
     * @return first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer
     * @param name - first name of the customer
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }

    /**
     * Get the last name of the customer
     * @return last name of the customer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer
     * @param name - last name of the customer
     */
    public void setLastName(String name) {
        this.lastName = name;
    }

    /**
     * Get the email of the customer
     * @return email of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the customer
     * @param email - email of the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the customer
     * @return phone number of the customer
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the customer
     * @param phone - phone number of the customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the address of the customer
     * @return address of the customer
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address of the customer
     * @param address - address of the customer
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get the payment method of the customer
     * @return payment method of the customer
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Set the payment method of the customer
     * @param paymentMethod - payment method of the customer
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
