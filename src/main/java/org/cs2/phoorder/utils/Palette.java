package org.cs2.phoorder.utils;

import java.util.Map;
import javafx.scene.paint.Color;

/**
 * Custom Color palettes for the app
 * @author Son Minh Nguyen(Simon Cao)
 * @version 16/04/2024
 */
public class Palette {

    /**
     * map of the names of colors and their hex values
     */
    private static final Map<String, String> palettes = Map.of(
            "primary", "#E64848",
            "secondary", "#FD8D14",
            "tertiary", "#77DD77",
            "base", "#FFFAB7",
            "black", "#000000",
            "white", "#FFFFFF"
            );

    /**
     * Get the hex code of the color based on their name
     * @param color - name of the color
     * @return Color - javafx Color
     */
    public static Color getColor(String color) {
        return Color.web(palettes.get(color));
    }

    public static String getHex(String color) {
        return palettes.get(color);
    }
}
