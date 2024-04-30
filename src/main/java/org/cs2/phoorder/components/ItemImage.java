package org.cs2.phoorder.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import org.cs2.phoorder.PhoOrderDriver;

import java.util.Objects;

public class ItemImage extends ImageView {
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
