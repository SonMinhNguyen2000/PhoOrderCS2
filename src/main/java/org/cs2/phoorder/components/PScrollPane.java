package org.cs2.phoorder.components;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

/**
 * Custom ScrollPane component for the app
 * extended from JavaFX ScrollPane, so it can be used the same
 * default background and border color to transparent
 * @author Son Minh Nguyen
 * @version 5/01/2024
 */
public class PScrollPane extends ScrollPane {

    /**
     * Constructor
     * @param contentBox - content to display (Javafx Node)
     */
    public PScrollPane(Node contentBox) {
        this.setContent(contentBox);
        this.setFitToWidth(true);
        this.setFitToHeight(true);
        this.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );
    }
}
