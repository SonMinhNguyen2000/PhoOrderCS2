package org.cs2.phoorder.models;

/**
 * A class that represents an item in the menu.
 */
public class Item {
    private String name;
    private double price = 0.0;
    private String category;
    private int quantity = 1;
    private String description;
    private String image;
    private String size;
    private String specialInstructions;

    /**
     * Constructor for Item
     * @param name - name of the item
     * @param description - description of the item
     * @param category - category of the item
     * @param price - price of the item
     * @param image - image of the item
     */
    public Item(
            String name,
            String description,
            String category,
            double price,
            String image
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.size = "small";
        this.specialInstructions = "";
    }

    /**
     * Constructor for Item, this is used for copying an item
     * @param item - item to copy
     */
    public Item(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.category = item.getCategory();
        this.image = item.getImage();
        this.size = item.getSize();
        this.specialInstructions = item.getSpecialInstructions();
    }

    /**
     * Get the name of the item
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the item
     * @param name - name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of the item
     * @return price of the item
     */
    public double getPrice() {
        return switch (size) {
            case "medium" -> price * 1.5;
            case "large" -> price * 2.0;
            default -> price;
        };
    }

    /**
     * Set the price of the item
     * @param price - price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the category of the item
     * @return category of the item
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the item
     * @param category - category of the item
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the quantity of the item
     * @return quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the item
     * @param quantity - quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the description of the item
     * @return description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the path to resources of the image of the item
     * @return the path image of the item
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the description of the item
     * @param description - description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the path to resources of the image of the item
     * @param image - path to the image of the item
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get the size of the item
     * @return size of the item
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the size of the item
     * @param size - size of the item
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Get the special instructions for the item
     * @return special instructions for the item
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Set the special instructions for the item
     * @param specialInstructions - special instructions for the item
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * Get the total price of the item
     * @return total price of the item
     */
    public double getTotal() {
        return switch (size) {
            case "medium" -> price * 1.5 * quantity;
            case "large" -> price * 2.0 * quantity;
            default -> price * quantity;
        };
    }
}
