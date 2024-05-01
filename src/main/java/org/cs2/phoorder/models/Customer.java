package org.cs2.phoorder.models;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private PaymentMethod paymentMethod;

    public Customer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phone = "";
        this.address = new Address();
        this.paymentMethod = new PaymentMethod();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
