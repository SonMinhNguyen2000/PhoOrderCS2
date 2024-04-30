package org.cs2.phoorder.models;

import java.util.ArrayList;

public class Order {
    private Customer customer;
    private final ArrayList<Item> items;

    public Order() {
        items = new ArrayList<Item>();
        customer = new Customer();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public String toString() {
        String order = "";
        for (Item item : items) {
            order += item.getName() + " - " + item.getQuantity() + " - " + item.getPrice() + "\n";
        }
        return order;
    }

    public void clear() {
        items.clear();
        customer = new Customer();
    }
}
