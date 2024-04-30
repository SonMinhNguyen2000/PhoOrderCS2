package org.cs2.phoorder.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.utils.Palette;

public class Navbar extends HBox {
    public Navbar() {
        this.setStyle(
                "-fx-background-color:" + Palette.getHex("primary") + ";" +
                "-fx-font-size: 18;" +
                "-fx-font-family: 'Lobster';" +
                "-fx-padding:0 15 0 15;"
        );
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        Button menu = new Button("Menu");
        menu.setOnAction(e -> onMenuClick());
        menu.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill:" + Palette.getHex("base") + ";" +
                "-fx-font-size: 18;"
        );
        PButton orderBtn = new PButton("base", "Order");
        String orderBtnStyle = orderBtn.getStyle();
        orderBtn.setStyle(
                orderBtnStyle +
                "-fx-font-family: 'Lobster';" +
                "-fx-font-size: 20;" +
                "-fx-text-fill:" + Palette.getHex("primary") + ";" +
                "-fx-padding: 1 30;"
        );
        orderBtn.setOnAction(e -> onOrderClick());
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        this.getChildren().add(new Logo());
        this.getChildren().add(menu);
        this.getChildren().add(spacer);
        this.getChildren().add(orderBtn);
    }

    public void onMenuClick() {
        PhoOrderDriver.root.updateCenter("menu");
    }

    public void onOrderClick() {
        PhoOrderDriver.root.updateCenter("cart");
    }
}
