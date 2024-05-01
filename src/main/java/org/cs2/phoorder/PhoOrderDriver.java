package org.cs2.phoorder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.models.Order;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import org.cs2.phoorder.layouts.RootPane;

/**
 * Main class to run the app
 */
public class PhoOrderDriver extends Application {

    //current order
    public static final Order order = new Order();

    //a list of all items in the menu
    public static ArrayList<Item> menu = new ArrayList<>();

    //root of the layout hierarchy
    public static RootPane root;

    @Override
    public void start(Stage stage) throws IOException {
        root = new RootPane();
        setupApp(stage, root);
    }

    /**
     * Set up the app
     * setup font, stage, icon, and scene
     * @param stage - stage of the app
     * @param root - root of the layout hierarchy
     */
    public void setupApp(Stage stage, BorderPane root) {
        Font.loadFont(
                Objects.requireNonNull(getClass().getResourceAsStream(
                        "Lobster-Regular.ttf"
                )),
                14
        );
        Image icon = new Image(
                Objects.requireNonNull(getClass().getResourceAsStream(
                        "logo.png"
                ))
        );
        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        stage.setTitle("Pho Order");
        stage.show();
        stage.getIcons().add(icon);
    }

    /**
     * Set up the food menu
     * Read the data from the file and add the items to the menu
     * @throws FileNotFoundException - file not found
     */
    public static void setupMenu() throws FileNotFoundException {
        try (Scanner scnr = new Scanner(new FileInputStream("data.txt"))) {
            while (scnr.hasNextLine()) {
               String name = scnr.nextLine().split(":")[1].trim();
               String description = scnr.nextLine().split(":")[1].trim();
               String category = scnr.nextLine().split(":")[1].trim();
               double price = Double.parseDouble(scnr.nextLine().split(":")[1].trim());
               String image = scnr.nextLine().split(":")[1].trim();
               Item item = new Item(name, description, category, price, image);
               menu.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        try {
            setupMenu();
            launch();
        } catch (FileNotFoundException e) {
            System.out.println("File Menu not found");
        }
    }
}