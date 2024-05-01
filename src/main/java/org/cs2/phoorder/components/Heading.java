package org.cs2.phoorder.components;

import javafx.scene.text.Text;
import org.cs2.phoorder.utils.Palette;

/**
 * Heading component for displaying large text and titles
 * extended from JavaFX Text, so it can be used the same
 * default text size to 24px with custom text color of primary
 * custom font Lobster and bold
 * @author Son Minh Nguyen (Simon Cao)
 * @version 5/01/2024
 */
public class Heading extends Text {

    /**
     * Constructor
     * @param text - text to display
     */
    public Heading(String text) {
        super(text);
        this.setFill(Palette.getColor("primary"));
        this.setStyle("-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Lobster';");
    }
}
