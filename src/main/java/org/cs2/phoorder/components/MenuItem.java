package org.cs2.phoorder.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.models.Item;

/**
 * MenuItem component to display in the menu pane
 * contains an image, name, description and order button
 * extended from JavaFX HBox, so it can be used the same
 * @author Son Minh Nguyen(Simon Cao)
 * @version 5/01/2024
 */
public class MenuItem extends HBox {

    // Item to display
    private final Item item;

    /**
     * Constructor
     * @param item - item to display
     */
    public MenuItem(Item item) {
        this.item = item;
        ItemImage image = new ItemImage(item.getImage());
        Heading name = new Heading(item.getName());
        Text description = new Text(item.getDescription());
        description.setWrappingWidth(200);
        description.setStyle(
                "-fx-font-size: 16; " +
                "-fx-font-family: 'Lobster';" +
                "-fx-font-weight: bold;");
        PButton orderBtn = new PButton("primary", "Order");
        orderBtn.setOnAction(e -> onBtnClick());
        VBox imageBox = new VBox(image, orderBtn);
        VBox descriptionBox = new VBox(name, description);
        imageBox.setSpacing(20);
        descriptionBox.setSpacing(10);
        imageBox.setAlignment(Pos.CENTER);
        descriptionBox.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(10);
        this.setStyle("-fx-padding: 10 0 20 0;");
        this.getChildren().addAll(imageBox, descriptionBox);
    }

    /**
     * Handle order click event
     * set the current item and update the center pane to item pane to display more details
     */
    public void onBtnClick() {
        PhoOrderDriver.root.currentItem = this.item;
        PhoOrderDriver.root.updateCenter("item");
    }
}
