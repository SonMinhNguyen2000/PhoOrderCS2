package org.cs2.phoorder.layouts;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.ItemImage;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.utils.Palette;

import java.util.ArrayList;

public class CartPane extends VBox {
    public CartPane() {
        ArrayList<Item> items = PhoOrderDriver.order.getItems();
        HBox title = new HBox();
        if (items.isEmpty()) {
            Heading empty = new Heading("Your current order is empty.");
            empty.setFill(Palette.getColor("black"));
            title.getChildren().add(empty);
            title.setAlignment(Pos.CENTER);
            title.setPadding(new Insets(10));
            this.getChildren().add(title);
        } else {
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
            this.getChildren().add(totalBox);
            this.setSpacing(20);
            this.setAlignment(Pos.TOP_CENTER);
        }
    }

    public void onRemoveBtnClick(Item item) {
        PhoOrderDriver.order.removeItem(item);
        PhoOrderDriver.root.updateCenter("cart");
    }

    public void onEditBtnClick(Item item) {
        PhoOrderDriver.root.currentItem = item;
        PhoOrderDriver.root.isEditingItem = true;
        PhoOrderDriver.root.updateCenter("item");
    }
}
