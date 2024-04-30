package org.cs2.phoorder.components;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.cs2.phoorder.utils.Palette;

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
