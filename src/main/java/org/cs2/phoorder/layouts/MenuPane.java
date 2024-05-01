package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.PScrollPane;
import org.cs2.phoorder.components.Spacer;
import org.cs2.phoorder.utils.Palette;
import org.cs2.phoorder.models.Item;
import org.cs2.phoorder.components.MenuItem;

import java.util.ArrayList;

public class MenuPane extends VBox {
    private final ChoiceBox<String> categories = new ChoiceBox<String>();
    private final GridPane grid;

    public MenuPane() {
        getCategories();
        categories.setValue(categories.getItems().getFirst());
        categories.setOnAction(e -> {
            updateMenu();
        });
        categories.setStyle(
                "-fx-font-size: 15;"
        );

        HBox subMenu = new HBox();
        Heading heading = new Heading("Categories");
        heading.setFill(Palette.getColor("black"));
        subMenu.getChildren().addAll(heading, categories);
        subMenu.setAlignment(Pos.CENTER);
        subMenu.setPadding(new Insets(15));
        subMenu.setSpacing(20);

        ArrayList<Item> items = getCategoryItems(categories.getValue());
        grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(new Background(
                new BackgroundFill(
                        Palette.getColor("base"),
                        null,
                        null)
                )
        );
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            MenuItem menuItem = new MenuItem(item);
            grid.add(menuItem, i % 2, i / 2);
        }
        PScrollPane scrollPane = new PScrollPane(grid);
        this.getChildren().addAll(
                subMenu,
                new Spacer(15),
                scrollPane
        );
    }

    public ArrayList<Item> getCategoryItems(String category) {
        ArrayList<Item> items = new ArrayList<Item>();
        for (Item item : PhoOrderDriver.menu) {
            if (item.getCategory().equals(category)) {
                items.add(item);
            }
        }
        return items;
    }

    public void getCategories() {
        for (Item item : PhoOrderDriver.menu) {
            if (!categories.getItems().contains(item.getCategory())) {
                categories.getItems().add(item.getCategory());
            }
        }
    }

    public void updateMenu() {
        grid.getChildren().clear();
        ArrayList<Item> items = getCategoryItems(categories.getValue());
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            MenuItem menuItem = new MenuItem(item);
            grid.add(menuItem, i % 2, i / 2);
        }
    }
}
