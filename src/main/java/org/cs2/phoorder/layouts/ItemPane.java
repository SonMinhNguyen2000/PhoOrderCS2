package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.ItemImage;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Item;

public class ItemPane extends HBox {
    private Item item;
    private ChoiceBox<String> sizeBox;
    private Spinner<Integer> quantitySpinner;
    private TextArea specialInstructions;

    public ItemPane(Item item, boolean isEditing) {
        this.item = item;

        this.sizeBox = new ChoiceBox<String>();
        this.sizeBox.getItems().addAll("Small", "Medium", "Large");
        this.sizeBox.setValue("Medium");


        ItemImage image = new ItemImage(item.getImage());
        image.setFitHeight(200);
        image.setFitWidth(200);
        image.setClip(new Circle(100, 100, 100));

        VBox imageBox = new VBox(image);
        VBox contentBox = new VBox();
        Heading name = new Heading(item.getName());
        name.setStyle(
                name.getStyle() +
                "-fx-font-size: 40;"
        );

        Text description = new Text(item.getDescription());
        description.setWrappingWidth(400);
        description.setStyle(
                "-fx-font-size: 20;" +
                "-fx-font-style: italic;" +
                "-fx-font-family: 'Inter';"
        );

        HBox sizeBox = new HBox();
        Heading sizeLabel = new Heading("Size: ");
        sizeLabel.setStyle(
                sizeLabel.getStyle() +
                "-fx-font-size: 20;");
        sizeBox.getChildren().addAll(sizeLabel, this.sizeBox);
        sizeBox.setSpacing(10);

        HBox quantityBox = new HBox();
        Heading quantityLabel = new Heading("Quantity: ");
        this.quantitySpinner = new Spinner<Integer>(1, 10, item.getQuantity());
        quantityLabel.setStyle(
                quantityLabel.getStyle() +
                "-fx-font-size: 20;");
        quantityBox.getChildren().addAll(quantityLabel, this.quantitySpinner);
        quantityBox.setSpacing(10);

        VBox specialInstructionsBox = new VBox();
        Heading specialInstructionsLabel = new Heading("Special Instructions:");
        specialInstructionsLabel.setStyle(
                specialInstructionsLabel.getStyle() +
                "-fx-font-size: 20;");
        this.specialInstructions = new TextArea(item.getSpecialInstructions());
        this.specialInstructions.setPromptText("Write here if you have any special instructions");
        this.specialInstructions.setWrapText(true);
        this.specialInstructions.setPrefWidth(400);
        this.specialInstructions.setPrefHeight(100);
        specialInstructionsBox.getChildren().addAll(
                specialInstructionsLabel,
                this.specialInstructions
        );
        specialInstructionsBox.setSpacing(10);

        contentBox.getChildren().addAll(
                name,
                description,
                quantityBox,
                specialInstructionsBox
                );

        if (!isEditing) {
            PButton orderBtn = new PButton("primary", "Order");
            orderBtn.setOnAction(e -> onOrderBtnClick());
            contentBox.getChildren().add(orderBtn);
        } else {
            PButton editBtn = new PButton("primary", "Edit");
            editBtn.setOnAction(e -> onEditBtnClick());
            contentBox.getChildren().add(editBtn);
        }

        contentBox.setSpacing(20);

        this.getChildren().addAll(imageBox, contentBox);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
    }

    public void onOrderBtnClick() {
        Item orderItem = new Item(
                this.item.getName(),
                this.item.getDescription(),
                this.item.getCategory(),
                this.item.getPrice(),
                this.item.getImage()
        );

        orderItem.setSize(this.sizeBox.getValue());
        orderItem.setQuantity(this.quantitySpinner.getValue());
        orderItem.setSpecialInstructions(this.specialInstructions.getText());
        PhoOrderDriver.order.addItem(orderItem);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText("Item added to order");
        alert.setContentText("You have added " + orderItem.getQuantity() + " " + orderItem.getSize() + " " + orderItem.getName() + " to your order");
        alert.showAndWait();
    }

    public void onEditBtnClick() {
        this.item.setSize(this.sizeBox.getValue());
        this.item.setQuantity(this.quantitySpinner.getValue());
        this.item.setSpecialInstructions(this.specialInstructions.getText());
        PhoOrderDriver.root.updateCenter("cart");
    }
}
