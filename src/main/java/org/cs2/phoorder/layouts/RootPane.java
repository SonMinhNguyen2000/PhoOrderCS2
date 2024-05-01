package org.cs2.phoorder.layouts;

import javafx.scene.layout.BorderPane;
import org.cs2.phoorder.components.Navbar;
import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.utils.Palette;

/**
 * RootPane is a BorderPane that contains the Navbar and the main content of the app.
 * It is the root of the layout hierarchy.
 * @author Son Minh Nguyen (Simon Cao)
 * @version 5/01/2024
 */
public class RootPane extends BorderPane {
    //current item being viewed or edited
    public Item currentItem;

    //flag to check if the item is being edited in the cart
    public boolean isEditingItem = false;

    /**
     * Constructor for RootPane
     */
    public RootPane() {
        this.setStyle(
                "-fx-background-color:" + Palette.getHex("base") + ";"
        );
        this.setTop(new Navbar());
        this.setCenter(new MenuPane());
    }

    /**
     * Clear the center of the RootPane
     */
    public void clearCenter() {
        this.setCenter(null);
    }

    /**
     * Update the center of the RootPane with a new pane
     * @param paneName - name of the pane to display
     */
    public void updateCenter(String paneName) {
        clearCenter();
        switch (paneName) {
            case "item":
                this.setCenter(new ItemPane(currentItem, isEditingItem));
                break;
            case "cart":
                this.setCenter(new CartPane());
                break;
            case "info":
                this.setCenter(new InfoPane());
                break;
            case "payment":
                this.setCenter(new PaymentPane());
                break;
            case "confirmation":
                this.setCenter(new ConfirmationPane());
                break;
            default:
                this.setCenter(new MenuPane());
        }
    }
}
