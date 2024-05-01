package org.cs2.phoorder.components;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.cs2.phoorder.utils.Palette;

/**
 * Custom Button component for the app
 * extended from JavaFX Button, so it can be used the same
 * default text size to 16px with String type to set background color
 * @author Son Minh Nguyen(Simon Cao)
 * @version 5/01/2024
 */
public class PButton extends Button {

    /**
     * Constructor
     * @param type - type of the button to set background color
     * @param text - text to display
     */
    public PButton(String type, String text) {
        super(text);
        this.setFont(Font.font("Inter", FontWeight.BOLD, 16));
        this.setStyle(
                "-fx-background-color: " + Palette.getHex(type) + ";" +
                "-fx-text-fill: white;" +
                "-fx-padding: 5 30;" +
                "-fx-border-radius: 10px;"
        );
    }
}
