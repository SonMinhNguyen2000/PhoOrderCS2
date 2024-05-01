package org.cs2.phoorder.components;

import javafx.scene.control.TextField;
import org.cs2.phoorder.utils.Palette;

/**
 * Custom Input component for the app
 * extended from JavaFX TextField, so it can be used the same
 * default text size to 16px with rounded and colored border of primary
 * @author Son Minh Nguyen
 * @version 5/01/2024
 */
public class Input extends TextField {

    /**
     * Constructor
     * @param placeholder - placeholder text to display
     */
    public Input(String placeholder) {
        this.setPromptText(placeholder);
        this.setStyle(
                "-fx-background-color:" + Palette.getHex("white") + ";" +
                "-fx-border-color:" + Palette.getHex("primary") + ";" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 10px;"
        );
    }
}
