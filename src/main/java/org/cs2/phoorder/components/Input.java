package org.cs2.phoorder.components;

import javafx.scene.control.TextField;
import org.cs2.phoorder.utils.Palette;

public class Input extends TextField {
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
