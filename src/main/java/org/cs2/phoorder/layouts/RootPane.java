package org.cs2.phoorder.layouts;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.cs2.phoorder.components.Navbar;
import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.utils.Palette;

public class RootPane extends BorderPane {
    public Item currentItem;
    public boolean isEditingItem = false;
    public RootPane() {
        this.setStyle(
                "-fx-background-color:" + Palette.getHex("base") + ";"
        );
        this.setTop(new Navbar());
        this.setCenter(new MenuPane());
    }

    public void clearCenter() {
        this.setCenter(null);
    }

    public void updateCenter(String paneName) {
        clearCenter();
        switch (paneName) {
            case "item":
                this.setCenter(new ItemPane(currentItem, isEditingItem));
                break;
            case "cart":
                this.setCenter(new CartPane());
                break;
//            case "checkout":
//                this.setCenter(new CheckoutPane());
//                break;
            default:
                this.setCenter(new MenuPane());
        }
    }
}
