package org.cs2.phoorder.components;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.cs2.phoorder.PhoOrderDriver;

import java.util.Objects;

public class Logo extends ImageView {

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