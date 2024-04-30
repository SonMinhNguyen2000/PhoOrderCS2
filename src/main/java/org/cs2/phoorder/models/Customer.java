package org.cs2.phoorder.models;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private Address address;
    private PaymentMethod paymentMethod;

    public Customer() {
        this.name = "";
        this.email = "";
        this.phone = "";
        this.address = null;
        this.paymentMethod = new PaymentMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
