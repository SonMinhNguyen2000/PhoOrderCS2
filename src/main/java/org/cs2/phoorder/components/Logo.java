package org.cs2.phoorder.components;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.cs2.phoorder.PhoOrderDriver;

import java.util.Objects;

/**
 * Logo component for displaying the logo of the app
 * extended from JavaFX ImageView, so it can be used the same
 * default image size to 65px with custom image
 * @author Son Minh Nguyen
 * @version 5/01/2024
 */
public class Logo extends ImageView {

    /**
     * Constructor
     */
    public Logo() {
        try {
            Image image = new Image(Objects.requireNonNull(PhoOrderDriver.class.getResourceAsStream("logo1.png")));
            this.setImage(image);
            this.setPreserveRatio(true);
        } catch (NullPointerException e) {
            System.err.println("Error loading logo image: " + e.getMessage());
        }
        this.setFitHeight(65);
        this.setFitWidth(65);
    }
}