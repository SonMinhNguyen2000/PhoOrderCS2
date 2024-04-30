package org.cs2.phoorder.components;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.cs2.phoorder.utils.Palette;

public class PButton extends Button {
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
