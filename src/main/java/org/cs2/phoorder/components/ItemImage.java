package org.cs2.phoorder.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import org.cs2.phoorder.PhoOrderDriver;

import java.util.Objects;

/**
 * ItemImage component for displaying images of items
 * extended from JavaFX ImageView, so it can be used the same
 * default image size to 150px with custom clip to circle
 * @author Son Minh Nguyen
 * @version 5/01/2024
 */
public class ItemImage extends ImageView {
    /**
     * Constructor
     * @param path - path to the image file in menu folder in resources
     */
    public ItemImage(String path) {
        super(new Image(
                Objects.requireNonNull(
                        PhoOrderDriver.class.getResourceAsStream("menu/" + path)
                )
        ));
        this.setFitHeight(150);
        this.setFitWidth(150);
        setClip(new Circle(75, 75, 75));
    }
}
