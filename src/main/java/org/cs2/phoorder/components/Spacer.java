package org.cs2.phoorder.components;

import javafx.scene.layout.HBox;

/**
 * Custom Spacer component for creating space between components
 * extended from JavaFX HBox, so it can be used the same
 * @author Son Minh Nguyen
 * @version 5/01/2024
 */
public class Spacer extends HBox {

    /**
     * Constructor
     * @param height - height of the spacer
     */
    public Spacer(double height) {
        this.setMinHeight(height);
    }
}
