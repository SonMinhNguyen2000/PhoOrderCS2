package org.cs2.phoorder.models;

import java.util.ArrayList;

/**
 * A class that represents an order.
 */
public class Order {
    private Customer customer;
    private final ArrayList<Item> items;

    /**
     * Constructor for Order
     */
    public Order() {
        items = new ArrayList<Item>();
        customer = new Customer();
    }

    /**
     * Add an item to the order
     * @param item - item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Remove an item from the order
     * @param item - item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Get the items in the order
     * @return items in the order
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Get an item by name
     * @param name - name of the item
     * @return item with the name
     */
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Set the customer of the order
     * @param customer - customer of the order
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get the customer of the order
     * @return customer of the order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get the total price of the order
     * @return total price of the order
     */
    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }


    /**
     * print the order
     */
    @Override
    public String toString() {
        String order = "";
        for (Item item : items) {
            order += item.getName() + " - " + item.getQuantity() + " - " + item.getPrice() + "\n";
        }
        return order;
    }

    /**
     * Clear the order - or remove all items and info from order
     */
    public void clear() {
        items.clear();
        customer = new Customer();
    }
}
