package org.cs2.phoorder.components;

import javafx.scene.layout.VBox;
import org.cs2.phoorder.components.Input;
import org.cs2.phoorder.components.Heading;

/**
 * Custom Input with Label component for the app
 * extended from JavaFX VBox, containing a heading as label and an input field
 */
public class InputWithLabel extends VBox {
    private final Input input = new Input("");

    /**
     * Constructor
     * @param nLabel - label text to display
     * @param nPlaceholder - placeholder text to display
     */
    public InputWithLabel(String nLabel, String nPlaceholder) {
        input.setPromptText(nPlaceholder);
        this.setSpacing(10);
        Heading label = new Heading("");
        label.setText(nLabel);
        label.setStyle(
            label.getStyle() +
            "-fx-font-size: 16;");
        this.getChildren().addAll(label, input);
    }

    /**
     * Set text of the input field
     * @param text - text to set
     */
    public void setText(String text) {
        input.setText(text);
    }

    /**
     * Get text of the input field
     * @return text of the input field
     */
    public String getText() {
        return input.getText();
    }

    /**
     * Get the input javaFx object(Input or TextField)
     * @return the input javaFx object(Input or TextField)
     */
    public Input getInput() {
        return input;
    }
}
