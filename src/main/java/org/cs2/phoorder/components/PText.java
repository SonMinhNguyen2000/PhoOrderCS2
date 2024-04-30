package org.cs2.phoorder.components;

import javafx.scene.text.Text;
import org.cs2.phoorder.utils.Palette;
import javafx.scene.text.Font;


/**
 * Custom Text component for the app
 * extended from JavaFX Text, so it can be used the same
 * default text size to 16px with custom text color
 * @author Son Minh Nguyen(Simon Cao)
 * @version 16/04/2024
 */
public class PText extends Text {

    /**
     * Constructor
     * @param text - text to display
     */
    public PText(String text) {
        this.setText(text);
        this.setFill(Palette.getColor("black"));
        this.setFont(Font.font("Inter", 16));
    }
}
