package org.cs2.phoorder.layouts;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.ItemImage;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.utils.Palette;

import java.util.ArrayList;

/**
 * CartPane is a VBox that displays the current order in the cart.
 * It displays the items in the cart, their quantity, price, and total.
 * It also provides buttons to edit or remove items from the cart.
 * And a checkout button
 * If the cart is empty, it displays a message saying so.
 * @author Son Minh Nguyen (Simon Cao)
 * @version 5/01/24
 */
public class CartPane extends VBox {

    /**
     * Constructor for CartPane
     */
    public CartPane() {

        //array of all items in the cart
        ArrayList<Item> items = PhoOrderDriver.order.getItems();

        HBox title = new HBox();

        //if the cart is empty, display a message
        if (items.isEmpty()) {
            Heading empty = new Heading("Your current order is empty.");
            empty.setFill(Palette.getColor("black"));
            title.getChildren().add(empty);
            title.setAlignment(Pos.CENTER);
            title.setPadding(new Insets(10));
            this.getChildren().add(title);
        } else { //if the cart is not empty, display the items in the cart
            Heading heading = new Heading("Your current order");
            title.getChildren().add(heading);
            title.setAlignment(Pos.CENTER);
            title.setPadding(new Insets(30));
            this.getChildren().add(title);
            for (Item item: items) {
                HBox itemBox = new HBox();
                ItemImage image = new ItemImage(item.getImage());
                Heading name = new Heading(item.getName());
                Heading price = new Heading("$" + item.getTotal());
                Heading quantity = new Heading("x" + item.getQuantity());
                name.setStyle(
                        name.getStyle() +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: 'Inter';"
                );
                price.setStyle(
                        price.getStyle() +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: 'Inter';"
                );
                quantity.setStyle(
                        quantity.getStyle() +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: 'Inter';"
                );

                VBox editBox = new VBox();
                PButton editBtn = new PButton("primary", "Edit");
                editBtn.setOnAction(e -> onEditBtnClick(item));
                PButton removeBtn = new PButton("secondary", "Remove");
                removeBtn.setOnAction(e -> onRemoveBtnClick(item));
                editBox.getChildren().addAll(editBtn, removeBtn);
                editBox.setSpacing(5);
                editBox.setAlignment(Pos.CENTER_LEFT);

                itemBox.getChildren().addAll(
                        image,
                        name,
                        price,
                        quantity,
                        editBox
                );
                itemBox.setSpacing(100);
                itemBox.setAlignment(Pos.CENTER);
                this.getChildren().add(itemBox);
            }

            HBox line = new HBox();
            line.setMaxSize(700, 2);
            line.setMinSize(700, 2);
            line.setStyle(
                    "-fx-background-color: black;"
            );
            this.getChildren().add(line);

            HBox totalBox = new HBox();
            Heading total = new Heading(
                String.format("Total: $ %.2f", PhoOrderDriver.order.getTotal())
            );
            total.setStyle(
                    total.getStyle() +
                    "-fx-font-size: 20;" +
                    "-fx-font-family: 'Inter';"
            );
            total.setFill(Palette.getColor("black"));
            totalBox.getChildren().add(total);
            totalBox.setAlignment(Pos.CENTER);

            PButton checkoutBtn = new PButton("tertiary", "Checkout");
            checkoutBtn.setOnAction(e -> {
                onCheckoutBtn();
            });
            this.getChildren().addAll(totalBox, checkoutBtn);
            this.setSpacing(20);
            this.setAlignment(Pos.TOP_CENTER);
        }
    }

    /**
     * is called when the remove button is clicked.
     * It removes the item from the cart and updates the cart and the pane
     * @param item the item to be removed
     */
    public void onRemoveBtnClick(Item item) {
        PhoOrderDriver.order.removeItem(item);
        PhoOrderDriver.root.updateCenter("cart");
    }

    /**
     * is called when the checkout button is clicked.
     * It updates the center pane to the info pane
     */
    public void onCheckoutBtn() {
        PhoOrderDriver.root.updateCenter("info");
    }

    /**
     * is called when the edit button is clicked.
     * change to the clicked item's pane
     * @param item the item to be edited
     */
    public void onEditBtnClick(Item item) {
        PhoOrderDriver.root.currentItem = item;
        PhoOrderDriver.root.isEditingItem = true;
        PhoOrderDriver.root.updateCenter("item");
    }
}
