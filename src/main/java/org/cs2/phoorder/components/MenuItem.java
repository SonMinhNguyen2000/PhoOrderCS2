package org.cs2.phoorder.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.models.Item;

public class MenuItem extends HBox {
    private Item item;

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

    public void onBtnClick() {
        PhoOrderDriver.root.currentItem = this.item;
        PhoOrderDriver.root.updateCenter("item");
    }
}
